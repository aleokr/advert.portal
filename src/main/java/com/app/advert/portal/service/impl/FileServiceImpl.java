package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.dto.FileResponse;
import com.app.advert.portal.elasticsearch.service.ElasticFileService;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.mapper.AdvertMapper;
import com.app.advert.portal.mapper.FileMapper;
import com.app.advert.portal.model.File;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.AmazonS3ClientService;
import com.app.advert.portal.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileMapper fileMapper;
    private final AmazonS3ClientService s3ClientService;
    private final ElasticFileService elasticFileService;
    private final AdvertMapper advertMapper;

    private final static String advertBucketName = "adverts";
    private final static String userBucketName = "users";
    private final static String companyBucketName = "companies";


    @Override
    public ResponseEntity<?> saveFile(FileDto fileDto, FileType fileType) throws IOException {
        String bucketName = getBucketName(fileDto.getResourceType());

        String s3Key = s3ClientService.addFile(bucketName, fileDto.getFileName(), fileDto.getFile(), fileDto.getContentType());

        //zapis w minio
        if (s3Key != null) {
            Long resourceId = fileDto.getResourceType().equals(ResourceType.ADVERT) ? fileDto.getResourceId() : (SecurityUtils.getLoggedCompanyId() != null ? SecurityUtils.getLoggedCompanyId() : SecurityUtils.getLoggedUserId());
            ResourceType resourceType = fileDto.getResourceType().equals(ResourceType.ADVERT) ? fileDto.getResourceType() : (SecurityUtils.getLoggedCompanyId() != null ? ResourceType.COMPANY : ResourceType.USER);
            File file = new File(fileDto.getFileName(), s3Key, fileDto.getContentType(), fileDto.getType(), resourceId, resourceType, fileType);
            fileMapper.saveFile(file);

            Long fileId = fileMapper.lastAddFileId();
            //zapis w elasticserach - zapisujemy tylko pliki .pdf
            if(fileType.equals(FileType.ATTACHMENT)){
                AdvertType advertType = null;

                if(resourceType.equals(ResourceType.ADVERT)){
                    advertType = advertMapper.getById(resourceId).getType();
                }
                fileDto.setId(fileId);
                elasticFileService.saveFile(encodeFileToElasticFile(fileDto), advertType);
            }

            return ResponseEntity.ok().body(fileMapper.getFileById(fileMapper.lastAddFileId()));
        }

        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<?> updateFile(FileDto fileDto) throws IOException {
        File file = fileMapper.getFileById(fileDto.getId());
        String s3Key = null;
        //zmiana pliku
        if(fileDto.getFile() != null) {
            String bucketName = getBucketName(file.getResourceType());
            s3ClientService.deleteFile(bucketName, file.getS3Key());
            s3Key = s3ClientService.addFile(bucketName, fileDto.getFileName(), fileDto.getFile(), fileDto.getContentType());
        }

        File updatedFile = new File();
        updatedFile.setId(file.getId());
        updatedFile.setS3Key(s3Key != null ? s3Key : file.getS3Key());
        updatedFile.setName(fileDto.getFileName() != null ? fileDto.getFileName() : file.getName());
        updatedFile.setContentType(file.getContentType() != null ? fileDto.getContentType() : file.getContentType());

        fileMapper.updateFile(updatedFile);

        //zapis w elasticserach - zapisujemy tylko pliki pdf
        if(updatedFile.getFileType().equals(FileType.ATTACHMENT)){
            AdvertType advertType = null;

            if(fileDto.getResourceType().equals(ResourceType.ADVERT)){
                advertType = advertMapper.getById(fileDto.getResourceId()).getType();
            }
            fileDto.setId(updatedFile.getId());
            elasticFileService.saveFile(encodeFileToElasticFile(fileDto), advertType);
        }

        return ResponseEntity.ok().body(fileMapper.getFileById(file.getId()));
    }

    @Override
    public ResponseEntity<?> deleteFile(Long id, File file) {
        if(file == null){
            file = fileMapper.getFileById(id);
        }
        s3ClientService.deleteFile(getBucketName(file.getResourceType()), file.getS3Key());
        fileMapper.deleteFile(id);
        return ResponseEntity.ok().build();
    }


    public List<FileResponse> getFilesDataByResourceId(Long resourceId, ResourceType resourceType){
        List<FileResponse> files = fileMapper.getFilesDataByResourceId(resourceId, resourceType);

        for(FileResponse file : files) {
            String path = s3ClientService.getFilePresignedFileUrl(getBucketName(resourceType), file.getS3Key());
            file.setFilePath(path);
        }
        return files;
    }

    public com.app.advert.portal.elasticsearch.document.File encodeFileToElasticFile(FileDto fileDto) throws IOException {
        com.app.advert.portal.elasticsearch.document.File elasticFIle = new com.app.advert.portal.elasticsearch.document.File();

        elasticFIle.setId(fileDto.getId());
        elasticFIle.setName(fileDto.getFileName());
        elasticFIle.setResourceId(fileDto.getResourceId());
        elasticFIle.setResourceType(fileDto.getResourceType().name());

        //wysłane dane muszą być zakodowane przez base64 do stringa
        elasticFIle.setData(new String(Base64.getEncoder().encode(fileDto.getFile().getBytes())));
        return elasticFIle;
    }

    private String getBucketName(ResourceType type) {
        String bucketName = null;

        if (type.equals(ResourceType.ADVERT)) {
            bucketName = advertBucketName;
        } else if (type.equals(ResourceType.USER)) {
            bucketName = userBucketName;
        } else {
            bucketName = companyBucketName;
        }
        return bucketName;
    }
}

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
import com.app.advert.portal.service.AmazonS3ClientService;
import com.app.advert.portal.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

    @Value("${amazonS3.advert.bucket}")
    private String advertBucketName;

    @Value("${amazonS3.user.bucket}")
    private String userBucketName;

    @Value("${amazonS3.company.bucket}")
    private String companyBucketName;


    @Override
    public File saveFile(FileDto fileDto) throws IOException {
        Long id = fileMapper.checkIfResourceFileExists(fileDto.getType(), fileDto.getResourceId());
        //jeśli istnieje to aktualizujemy
        if (id != null) {
            fileDto.setId(id);
            return updateFile(fileDto);
        } else {
            String bucketName = getBucketName(fileDto.getResourceType());

            String s3Key = s3ClientService.addFile(bucketName, fileDto.getFileName(), fileDto.getFile(), fileDto.getContentType());

            //zapis w minio
            if (s3Key != null) {
                Long resourceId = fileDto.getResourceId();
                ResourceType resourceType = fileDto.getResourceType();
                File file = new File(fileDto.getFileName(), s3Key, fileDto.getContentType(), fileDto.getType(), resourceId, resourceType);
                fileMapper.saveFile(file);

                Long fileId = fileMapper.getFilesByResourceId(resourceId, resourceType).get(0).getId();
                //zapis w elasticserach - zapisujemy tylko pliki .pdf
                if (fileDto.getType().equals(FileType.ATTACHMENT)) {
                    AdvertType advertType = null;

                    if (resourceType.equals(ResourceType.ADVERT)) {
                        advertType = advertMapper.getById(resourceId).getType();
                    }
                    fileDto.setId(fileId);
                    elasticFileService.saveFile(encodeFileToElasticFile(fileDto), advertType);
                }

                return fileMapper.getFileById(fileId);
            }

            return null;
        }
    }

    @Override
    public File updateFile(FileDto fileDto) throws IOException {
        File file = fileMapper.getFileById(fileDto.getId());
        String s3Key = null;
        String bucketName = getBucketName(file.getResourceType());
        s3ClientService.deleteFile(bucketName, file.getS3Key());
        s3Key = s3ClientService.addFile(bucketName, fileDto.getFileName(), fileDto.getFile(), fileDto.getContentType());


        File updatedFile = new File();
        updatedFile.setId(file.getId());
        updatedFile.setS3Key(s3Key != null ? s3Key : file.getS3Key());
        updatedFile.setName(fileDto.getFileName() != null ? fileDto.getFileName() : file.getName());
        updatedFile.setType(fileDto.getType());
        updatedFile.setContentType(file.getContentType() != null ? fileDto.getContentType() : file.getContentType());

        fileMapper.updateFile(updatedFile);

        //zapis w elasticserach - zapisujemy tylko pliki pdf
        if (updatedFile.getType().equals(FileType.ATTACHMENT)) {
            AdvertType advertType = null;

            if (fileDto.getResourceType().equals(ResourceType.ADVERT)) {
                advertType = advertMapper.getById(fileDto.getResourceId()).getType();
            }
            fileDto.setId(updatedFile.getId());
            elasticFileService.saveFile(encodeFileToElasticFile(fileDto), advertType);
        }

        return fileMapper.getFileById(file.getId());
    }

    @Override
    public void deleteFile(Long id, File file) {
        if (file == null) {
            file = fileMapper.getFileById(id);
        }
        s3ClientService.deleteFile(getBucketName(file.getResourceType()), file.getS3Key());
        fileMapper.deleteFile(id);
    }

    @Override
    public List<FileResponse> getFilesDataByResourceId(Long resourceId, ResourceType resourceType) {
        List<FileResponse> files = fileMapper.getFilesDataByResourceId(resourceId, resourceType);

        for (FileResponse file : files) {
            String path = s3ClientService.getFileAssignedFileUrl(getBucketName(resourceType), file.getS3Key());
            file.setFilePath(path);
        }
        return files;
    }

    private com.app.advert.portal.elasticsearch.document.File encodeFileToElasticFile(FileDto fileDto) throws IOException {
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

package com.app.advert.portal.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AmazonS3ClientService {

    private final AmazonS3 s3Client;

    private String generateFileKey(String fileName, String bucketName) {
        String fileKey = fileName + bucketName + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(fileKey.getBytes(StandardCharsets.UTF_8));
    }

    public boolean checkIfBucketExists(String bucketName) {
        return s3Client.doesBucketExist(bucketName);
    }

    public void createBucket(String bucketName) {
        if (!checkIfBucketExists(bucketName)) {
            s3Client.createBucket(bucketName);
        }
    }

    public String addFile(String bucketName, String fileName, MultipartFile file, String contentType) throws IOException {
        String fileKey = generateFileKey(fileName, bucketName);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(contentType);
        s3Client.putObject(bucketName, fileKey, file.getInputStream(), objectMetadata);
        return fileKey;
    }

    public String getFileUrl(String bucketName, String fileKey) {
        return s3Client.getUrl(bucketName, fileKey).toString();
    }

    public String getFilePresignedFileUrl(String bucketName, String fileKey) {
        return s3Client.generatePresignedUrl(bucketName, fileKey, new Date(System.currentTimeMillis() + 3600000)).toString();
    }

    public void deleteFile(String bucketName, String fileKey) {
        s3Client.deleteObject(bucketName, fileKey);
    }
}


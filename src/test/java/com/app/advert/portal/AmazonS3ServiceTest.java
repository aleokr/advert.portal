package com.app.advert.portal;

import com.app.advert.portal.service.AmazonS3ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@ActiveProfiles("test")
@SpringBootTest
public class AmazonS3ServiceTest {

    @Autowired
    AmazonS3ClientService amazonS3ClientService;

    @Test
    public void createBucket() {
        //when
        amazonS3ClientService.createBucket("bucket");

        //then
        assertTrue(amazonS3ClientService.checkIfBucketExists("bucket"));
    }

    @Test
    public void addFile() throws IOException {
        //given
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);

        //when
        String s3Key = amazonS3ClientService.addFile("test", "test_file", multipartFile, "application/pdf");

        //then
        assertNotNull(s3Key);
        assertFalse(s3Key.isEmpty());
    }

    @Test
    public void getFileUrl() throws IOException {
        //given
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);
        String s3Key = amazonS3ClientService.addFile("test", "test_file", multipartFile, "application/pdf");

        //when
        String filePath = amazonS3ClientService.getFileUrl("test", s3Key);

        //then
        assertNotNull(filePath);
        assertFalse(filePath.isEmpty());
    }

    @Test
    public void getFileAssignedFileUrl() throws IOException {
        //given
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);
        String s3Key = amazonS3ClientService.addFile("test", "test_file", multipartFile, "application/pdf");

        //when
        String filePath = amazonS3ClientService.getFileAssignedFileUrl("test", s3Key);

        //then
        assertNotNull(filePath);
        assertFalse(filePath.isEmpty());
    }

    @Test
    public void deleteFile() throws IOException {
        //given
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);
        String s3Key = amazonS3ClientService.addFile("delete", "test_file", multipartFile, "application/pdf");

        //when
        amazonS3ClientService.deleteFile("delete", s3Key);
        String filePath = amazonS3ClientService.getFileAssignedFileUrl("testDelete", s3Key);

    }
}

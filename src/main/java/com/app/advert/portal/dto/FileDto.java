package com.app.advert.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@Data
public class FileDto {

    private MultipartFile file;

    private String fileName;

    private String bucketName;

    private String contentType;

}

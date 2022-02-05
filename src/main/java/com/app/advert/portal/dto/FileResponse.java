package com.app.advert.portal.dto;

import com.app.advert.portal.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {

    private Long id;

    private String fileName;

    private String filePath;

    private FileType fileType;

    private String s3Key;

    private String contentType;
}

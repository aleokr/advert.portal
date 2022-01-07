package com.app.advert.portal.dto;

import com.app.advert.portal.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {

    Long id;

    String fileName;

    String filePath;

    FileType fileType;

    String s3Key;

    String contentType;
}

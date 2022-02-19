package com.app.advert.portal.dto;

import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileDto {

    private Long id;

    private MultipartFile file;

    private String fileName;

    private String contentType;

    private FileType type;

    private Long resourceId;

    private ResourceType resourceType;

}

package com.app.advert.portal.model;

import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    private Long id;

    private String name;

    private String s3Key;

    private String contentType;

    private FileType type;

    private Long resourceId;

    private ResourceType resourceType;


    public File(String name, String s3Key, String contentType, FileType type, Long resourceId, ResourceType resourceType) {
        this.name = name;
        this.s3Key = s3Key;
        this.contentType = contentType;
        this.type = type;
        this.resourceId = resourceId;
        this.resourceType = resourceType;
    }

}

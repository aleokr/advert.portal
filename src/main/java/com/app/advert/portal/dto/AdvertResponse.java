package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.model.Tag;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
public class AdvertResponse {

    private Long id;

    private String title;

    private String shortDescription;

    private String longDescription;

    private boolean archived;

    private Long ownerId;

    private Boolean applicationExists;

    private AdvertCategory advertCategory;

    private AdvertType advertType;

    private String createdAt;

    private String addedBy;

    private Long count;

    private Boolean canEdit;

    private Boolean canApplicate;

    private List<Tag> tags;

    private String mainFilePath;

    public AdvertResponse(Long id, String title, String shortDescription, String longDescription, boolean archived, Long ownerId, AdvertCategory advertCategory, AdvertType advertType, String createdAt, String addedBy) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.archived = archived;
        this.ownerId = ownerId;
        this.advertCategory = advertCategory;
        this.advertType = advertType;
        this.createdAt = createdAt;
        this.addedBy = addedBy;
    }

    public AdvertResponse(Long id, String title, String shortDescription, String longDescription, boolean archived, Long ownerId, AdvertCategory advertCategory, AdvertType advertType, String createdAt, String addedBy, Long count) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.archived = archived;
        this.ownerId = ownerId;
        this.advertCategory = advertCategory;
        this.advertType = advertType;
        this.createdAt = createdAt;
        this.addedBy = addedBy;
        this.count = count;
    }
}

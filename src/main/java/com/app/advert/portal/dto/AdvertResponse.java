package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import lombok.*;


@Data
@AllArgsConstructor
public class AdvertResponse {

    Long id;

    String title;

    String shortDescription;

    String longDescription;

    Long ownerId;

    Boolean applicationExists;

    AdvertCategory advertCategory;

    AdvertType advertType;

    String createdAt;

    String addedBy;

    Boolean canEdit;

    Boolean canApplicate;

    public AdvertResponse(Long id, String title, String shortDescription, String longDescription, Long ownerId, AdvertCategory advertCategory, AdvertType advertType, String createdAt, String addedBy) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.ownerId = ownerId;
        this.advertCategory = advertCategory;
        this.advertType = advertType;
        this.createdAt = createdAt;
        this.addedBy = addedBy;
    }
}

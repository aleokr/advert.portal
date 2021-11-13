package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.model.Tag;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
public class AdvertResponse {

    Long id;

    String title;

    String shortDescription;

    String longDescription;

    boolean archived;

    Long ownerId;

    Boolean applicationExists;

    AdvertCategory advertCategory;

    AdvertType advertType;

    String createdAt;

    String addedBy;

    Long count;

    Boolean canEdit;

    Boolean canApplicate;

    List<Tag> tags;

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

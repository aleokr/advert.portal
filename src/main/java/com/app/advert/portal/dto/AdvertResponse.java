package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import lombok.*;


@Value
@Builder
@Getter
@AllArgsConstructor
public class AdvertResponse {

    Long id;

    String title;

    String shortDescription;

    String longDescription;

    Long userId;

    Boolean applicationExists;

    AdvertCategory advertCategory;

    AdvertType advertType;

    String createdAt;

    String addedBy;

}

package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.service.ApplicationService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@Getter
@AllArgsConstructor
public class ApplicationResponse {

    Long advertId;

    String advertTitle;

    String advertShortDescription;

    Long userId;

    String addedBy;

    Long companyId;

    AdvertCategory advertCategory;

    String createdAt;
}

package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.service.ApplicationService;
import lombok.*;

@Data
@AllArgsConstructor
public class ApplicationResponse {

    Long advertId;

    String advertTitle;

    String advertShortDescription;

    Long userId;

    String addedBy;

    Long companyId;

    AdvertCategory advertCategory;

    AdvertType advertType;

    String createdAt;
}

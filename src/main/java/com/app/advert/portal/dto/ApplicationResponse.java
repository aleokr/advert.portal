package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.service.ApplicationService;
import lombok.*;

@Data
@AllArgsConstructor
public class ApplicationResponse {

    private Long advertId;

    private String advertTitle;

    private String advertShortDescription;

    private Long userId;

    private String addedBy;

    private Long companyId;

    private AdvertCategory advertCategory;

    private AdvertType advertType;

    private String createdAt;
}

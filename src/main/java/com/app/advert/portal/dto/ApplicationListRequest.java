package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@Getter
public class ApplicationListRequest {

    Long userId;

    Long companyId;

    Long limit;

    Long offset;
}

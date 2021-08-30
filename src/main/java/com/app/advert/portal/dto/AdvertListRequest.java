package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@Getter
public class AdvertListRequest {

    Long id;

    Long userId;

    Long companyId;

    Long offset;

    Long limit;
}
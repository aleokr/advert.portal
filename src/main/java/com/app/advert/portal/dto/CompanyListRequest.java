package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CompanyListRequest {

    String name;

    Long offset;

    Long limit;

}

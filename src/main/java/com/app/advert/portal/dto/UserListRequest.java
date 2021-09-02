package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserListRequest {

    Long companyId;

    Long offset;

    Long limit;

    Boolean active;
}

package com.app.advert.portal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListRequest {

    Long companyId;

    Long offset;

    Long limit;

    Boolean active;
}

package com.app.advert.portal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListRequest {

    private Long companyId;

    private Long offset;

    private Long limit;

    private Boolean active;
}

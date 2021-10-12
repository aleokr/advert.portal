package com.app.advert.portal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationListRequest {

    Long userId;

    Long companyId;

    Long limit;

    Long offset;
}

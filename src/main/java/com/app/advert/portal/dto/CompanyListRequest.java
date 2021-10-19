package com.app.advert.portal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyListRequest {

    String name;

    Long offset;

    Long limit;

}

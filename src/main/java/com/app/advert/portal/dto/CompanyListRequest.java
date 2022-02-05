package com.app.advert.portal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyListRequest {

    private String name;

    private Long offset;

    private Long limit;

}

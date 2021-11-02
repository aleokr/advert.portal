package com.app.advert.portal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationListRequest {

    private Long userId;

    private Long companyId;

    private Integer limit;

    private Integer offset;
}

package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertListRequest {

    Long id;

    Long userId;

    Long companyId;

    Long offset;

    Long limit;

    AdvertType type;

    boolean count;
}

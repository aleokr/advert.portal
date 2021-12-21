package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertListRequest {

    Long id;

    Long userId;

    Long companyId;

    Integer offset;

    Integer limit;

    AdvertType type;

    String searchText;
}

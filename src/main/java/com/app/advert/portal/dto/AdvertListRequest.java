package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvertListRequest {

    private Long id;

    private Long userId;

    private Long companyId;

    private Integer offset;

    private Integer limit;

    private AdvertType type;

    private String searchText;

    private boolean similarFiles;

    public AdvertListRequest(AdvertType type, Integer offset, Integer limit) {
        this.type = type;
        this.offset = offset;
        this.limit = limit;
    }
}

package com.app.advert.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingResponse {

    private Integer page;

    private Integer pagesCount;

    private Integer totalCount;

}

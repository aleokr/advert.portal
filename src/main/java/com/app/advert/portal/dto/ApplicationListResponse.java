package com.app.advert.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationListResponse {

    private PagingResponse paging;

    private List<ApplicationResponse> applications;
}

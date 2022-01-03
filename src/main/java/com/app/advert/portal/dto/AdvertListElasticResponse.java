package com.app.advert.portal.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdvertListElasticResponse {

    private List<Long> advertIds;

    private long totalCount;
}

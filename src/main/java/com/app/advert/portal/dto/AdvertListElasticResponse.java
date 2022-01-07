package com.app.advert.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertListElasticResponse {

    private Set<Long> advertIds;

    private long totalCount;
}

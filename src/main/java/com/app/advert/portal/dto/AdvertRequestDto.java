package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@Getter
public class AdvertRequestDto {

    Long id;

    String title;

    String shortDescription;

    String longDescription;

}

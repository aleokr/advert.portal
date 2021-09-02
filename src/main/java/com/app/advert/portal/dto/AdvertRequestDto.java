package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
@Builder
@Getter
public class AdvertRequestDto {

    Long id;

    @NotEmpty
    String title;

    @NotEmpty
    String shortDescription;

    String longDescription;

}

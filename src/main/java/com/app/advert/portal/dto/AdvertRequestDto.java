package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertRequestDto {

    Long id;

    @NotEmpty
    String title;

    @NotEmpty
    String shortDescription;

    String longDescription;

    AdvertCategory category;

}

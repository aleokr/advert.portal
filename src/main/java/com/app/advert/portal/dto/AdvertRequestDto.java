package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertRequestDto {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String shortDescription;

    private String longDescription;

    private AdvertCategory category;

    private List<Long> tagIds;
}

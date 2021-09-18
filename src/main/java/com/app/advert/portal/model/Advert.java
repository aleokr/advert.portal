package com.app.advert.portal.model;

import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advert {

    private Long id;

    private String title;

    private String shortDescription;

    private String longDescription;

    private Long userId;

    private AdvertCategory category;

    private AdvertType type;

}

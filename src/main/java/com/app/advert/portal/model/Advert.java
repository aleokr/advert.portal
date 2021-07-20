package com.app.advert.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advert {

    private long id;

    private String title;

    private String shortDescription;

    private String longDescription;

}

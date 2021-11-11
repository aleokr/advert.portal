package com.app.advert.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagResponse {

    @JsonProperty("value")
    private Long id;

    @JsonProperty("label")
    private String name;
}

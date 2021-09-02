package com.app.advert.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@Getter
@AllArgsConstructor
public class ApplicationResponse {

    Long advertId;

    String advertTitle;

    Long userId;

    String userName;

    Long companyId;

    String companyName;
}

package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserResponse {

    Long id;

    String name;

    String surname;

    String email;
}

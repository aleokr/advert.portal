package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import lombok.*;

@Value
@Builder
@Getter
public class UserDto {

    Long id;

    String name;

    String surname;

    String email;

    String login;

    String password;

    UserRole userRole;
}

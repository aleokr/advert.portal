package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import lombok.*;

@Value
@Builder
@Getter
public class UserRequestDto {

    Long id;

    String name;

    String surname;

    String email;

    String login;

    String password;

    UserRole userRole;

    Long companyId;
}

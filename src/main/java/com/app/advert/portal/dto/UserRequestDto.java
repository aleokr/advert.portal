package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Value
@Builder
@Getter
public class UserRequestDto {

    Long id;

    @NotEmpty
    String name;

    @NotEmpty
    String surname;

    @NotEmpty
    String email;

    @NotEmpty
    String login;

    @NotEmpty
    String password;

    UserRole userRole;

    Long companyId;
}

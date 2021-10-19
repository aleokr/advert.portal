package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    String password;

    UserRole userRole;

    Long companyId;
}

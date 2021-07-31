package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    String name;

    String surname;

    String email;

    String login;

    String password;

    UserRole userRole;
}

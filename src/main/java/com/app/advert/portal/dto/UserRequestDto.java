package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String email;

    @NotEmpty
    private String login;

    private String password;

    private UserRole userRole;

    private Long companyId;
}

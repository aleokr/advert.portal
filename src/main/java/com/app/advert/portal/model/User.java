package com.app.advert.portal.model;

import com.app.advert.portal.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String login;

    @JsonIgnore
    private String password;

    private Long companyId;

    private UserRole type;

    private List<Role> roles;

    private Boolean active;

    public User(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}

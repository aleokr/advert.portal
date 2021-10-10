package com.app.advert.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    public UserResponse(Long id, String name, String surname, String email, String login) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
    }

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String login;

    private Integer advertsCount;

    private Integer responsesCount;

    private Integer applicationsCount;
}

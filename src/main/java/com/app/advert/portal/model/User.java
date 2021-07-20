package com.app.advert.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;

    private String name;

    private String surname;

    private String email;

    private String login;

    private String password;

    private Timestamp createdAt;
}

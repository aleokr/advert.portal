package com.app.advert.portal.dto;

import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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

    private Long companyId;

    private Boolean active;

    private UserRole type;

    private Integer advertsCount;

    private Integer responsesCount;

    private Integer applicationsCount;

    private List<Tag> tags;

    private List<FileResponse> files;
}

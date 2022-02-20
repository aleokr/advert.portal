package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CompanyResponse {

    private Long id;

    private String name;

    private String description;

    private List<UserResponse> members;

    private List<UserResponse> requestToJoin;

    private String imagePath;

    private String mainFilePath;
}

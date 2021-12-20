package com.app.advert.portal.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Value;

import java.util.List;

@Builder
@Data
public class CompanyResponse {

    private Long id;

    private String name;

    private String description;

    private List<UserResponse> members;

    private List<UserResponse> requestToJoin;

    private List<FileResponse> files;
}

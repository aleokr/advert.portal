package com.app.advert.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private Long id;

    private Long advertId;

    private Long userId;

    private Long companyId;
}

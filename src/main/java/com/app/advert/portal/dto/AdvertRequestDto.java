package com.app.advert.portal.dto;

import com.app.advert.portal.enums.AdvertCategory;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertRequestDto {

    Long id;

    @NotEmpty
    String title;

    @NotEmpty
    String shortDescription;

    String longDescription;

    AdvertCategory category;

    List<Long> tagIds;
}

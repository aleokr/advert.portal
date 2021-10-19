package com.app.advert.portal.dto;

import com.app.advert.portal.enums.TagType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceTagRequestDto {

    Long tagId;

    Integer resourceId;

    TagType type;
}

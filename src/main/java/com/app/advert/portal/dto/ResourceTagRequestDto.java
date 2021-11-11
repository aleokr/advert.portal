package com.app.advert.portal.dto;

import com.app.advert.portal.enums.TagType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceTagRequestDto {

    List<Long> tagIds;

    Integer resourceId;

    TagType type;
}

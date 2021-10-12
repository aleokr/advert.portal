package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.ResourceTagRequestDto;
import com.app.advert.portal.enums.TagType;
import com.app.advert.portal.mapper.TagMapper;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;

    @Override
    public ResponseEntity<?> saveTag(String name) {
        if (name == null) {
            return ResponseEntity.unprocessableEntity().body("No name ");
        }
        if (tagMapper.getTagByName(name.toLowerCase()) != null) {
            return ResponseEntity.unprocessableEntity().body("Tag has already exists ");
        }
        tagMapper.saveTag(name.toLowerCase());

        return ResponseEntity.ok().body(tagMapper.getTagByName(name.toLowerCase()));
    }

    @Override
    public ResponseEntity<?> saveResourceTag(ResourceTagRequestDto request) {
        if (tagMapper.getTagById(request.getTagId()) == null) {
            return ResponseEntity.unprocessableEntity().body("Tag doesn't exist ");
        }
        tagMapper.saveResourceTag(request.getType().equals(TagType.USER) ? (SecurityUtils.getLoggedCompanyId() != null ? SecurityUtils.getLoggedCompanyId() : SecurityUtils.getLoggedUserId()) : request.getResourceId(), request.getTagId());

        return ResponseEntity.ok().build();
    }
}

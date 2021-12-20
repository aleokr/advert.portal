package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.ResourceTagRequestDto;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.mapper.TagMapper;
import com.app.advert.portal.model.Tag;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
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
        Tag tag = tagMapper.getTagByName(name.toLowerCase());

        List<Long> tagIds = new ArrayList<>();
        tagIds.add(tag.getId());
        saveResourceTag(new ResourceTagRequestDto(tagIds, null, ResourceType.USER));

        return ResponseEntity.ok().body(tagMapper.getTagByName(name.toLowerCase()));
    }

    @Override
    public ResponseEntity<?> saveResourceTag(ResourceTagRequestDto request) {
        Long resourceId = request.getType().equals(ResourceType.USER) ? (SecurityUtils.getLoggedCompanyId() != null ? SecurityUtils.getLoggedCompanyId() : SecurityUtils.getLoggedUserId()) : request.getResourceId();
        ResourceType resourceType = request.getType().equals(ResourceType.USER) ? (SecurityUtils.getLoggedCompanyId() != null ? ResourceType.COMPANY : ResourceType.USER) : request.getType();

        for (Long tagId : request.getTagIds()) {
            if (tagMapper.getTagById(tagId) == null) {
                log.warn("Tag with id: " + tagId + " doesn't exist ");
                break;
            }
            if (!tagMapper.checkIfResourceTagExists(resourceId, tagId, resourceType)) {
                tagMapper.saveResourceTag(resourceId, tagId, resourceType);
            }
        }


        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getTagsList(Integer limit, Integer offset) {
        return ResponseEntity.ok().body(tagMapper.getTagsList(limit, offset));
    }

    @Override
    public ResponseEntity<?> getAvailableTagsList() {
        return ResponseEntity.ok().body(tagMapper.getAvailableTagsList(SecurityUtils.getLoggedCompanyId() != null ? SecurityUtils.getLoggedCompanyId() : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId() != null ? ResourceType.COMPANY : ResourceType.USER));
    }
}

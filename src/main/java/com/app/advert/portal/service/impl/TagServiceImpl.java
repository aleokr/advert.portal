package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.ResourceTagRequestDto;
import com.app.advert.portal.dto.TagResponse;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.mapper.TagMapper;
import com.app.advert.portal.model.Tag;
import com.app.advert.portal.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Tag saveTag(String name, Long companyId, Long userId) {
        if (tagMapper.getTagByName(name.toLowerCase()) != null) {
            return null;
        }
        tagMapper.saveTag(name.toLowerCase());
        Tag tag = tagMapper.getTagByName(name.toLowerCase());

        List<Long> tagIds = new ArrayList<>();
        tagIds.add(tag.getId());
        saveResourceTag(new ResourceTagRequestDto(tagIds, null, ResourceType.USER), companyId, userId);

        return tagMapper.getTagByName(name.toLowerCase());
    }

    @Override
    public void saveResourceTag(ResourceTagRequestDto request, Long companyId, Long userId) {
        Long resourceId = request.getType().equals(ResourceType.USER) ? (companyId != null ? companyId : userId) : request.getResourceId();
        ResourceType resourceType = request.getType().equals(ResourceType.USER) ? (companyId != null ? ResourceType.COMPANY : ResourceType.USER) : request.getType();

        for (Long tagId : request.getTagIds()) {
            if (tagMapper.getTagById(tagId) == null) {
                log.warn("Tag with id: " + tagId + " doesn't exist ");
                break;
            }
            if (!tagMapper.checkIfResourceTagExists(resourceId, tagId, resourceType)) {
                tagMapper.saveResourceTag(resourceId, tagId, resourceType);
            }
        }
    }

    @Override
    public List<TagResponse> getTagsList(Integer limit, Integer offset) {
        return tagMapper.getTagsList(limit, offset);
    }

    @Override
    public List<TagResponse> getAvailableTagsList(Long companyId, Long userId) {
        return tagMapper.getAvailableTagsList(companyId != null ? companyId : userId, companyId != null ? ResourceType.COMPANY : ResourceType.USER);
    }
}

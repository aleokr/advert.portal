package com.app.advert.portal.service;

import com.app.advert.portal.dto.ResourceTagRequestDto;
import com.app.advert.portal.dto.TagResponse;
import com.app.advert.portal.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {

    Tag saveTag(String name, Long companyId, Long userId);

    void saveResourceTag(ResourceTagRequestDto request, Long companyId, Long userId);

    List<TagResponse> getTagsList(Integer limit, Integer offset);

    List<TagResponse> getAvailableTagsList(Long companyId, Long userId);
}

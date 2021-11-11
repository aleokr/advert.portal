package com.app.advert.portal.service;

import com.app.advert.portal.dto.ResourceTagRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TagService {

    ResponseEntity<?> saveTag(String name);

    ResponseEntity<?> saveResourceTag(ResourceTagRequestDto request);

    ResponseEntity<?> getTagsList(Integer limit, Integer offset);

    ResponseEntity<?> getAvailableTagsList();
}

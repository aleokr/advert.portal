package com.app.advert.portal.service;

import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertListRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public interface AdvertService {

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> getAdverts(AdvertListRequest request) throws IOException;

    ResponseEntity<?> saveAdvert(AdvertRequestDto advertRequestDto) throws IOException;

    ResponseEntity<?> updateAdvert(AdvertRequestDto advertRequestDto);

    ResponseEntity<?> deleteAdvert(Long advertId);

    ResponseEntity<?> archivedAdvert(Long advertId);

    ResponseEntity<?> getAdvertCategories();
}

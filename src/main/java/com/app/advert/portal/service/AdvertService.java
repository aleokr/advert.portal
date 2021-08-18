package com.app.advert.portal.service;

import com.app.advert.portal.dto.AdvertDto;
import com.app.advert.portal.dto.AdvertListRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface AdvertService {

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> getAdverts(AdvertListRequest request);

    ResponseEntity<?> saveAdvert(AdvertDto advertDto);

    ResponseEntity<?> updateAdvert(AdvertDto advertDto);

    ResponseEntity<?> deleteAdvert(Long advertId);

    ResponseEntity<?> archivedAdvert(Long advertId);
}

package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.AdvertDto;
import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.mapper.AdvertMapper;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertMapper advertMapper;

    @Override
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok().body(advertMapper.getById(id));
    }

    @Override
    public ResponseEntity<?> getAdverts(AdvertListRequest request) {
        return ResponseEntity.ok().body(advertMapper.getAdvertList(request));
    }

    @Override
    public ResponseEntity<?> saveAdvert(AdvertDto advertDto) {
        Advert advert = new Advert(null, advertDto.getTitle(), advertDto.getShortDescription(), advertDto.getLongDescription(), SecurityUtils.getLoggedUserId());
        advertMapper.saveAdvert(advert);
        return ResponseEntity.ok().body(advertMapper.getById(advertMapper.lastAddAdvertId()));
    }

    @Override
    public ResponseEntity<?> updateAdvert(AdvertDto advertDto) {

        if (checkAccessToAdvert(advertDto.getId())){
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        Advert advert = advertMapper.getById(advertDto.getId());
        advert.setLongDescription(advertDto.getLongDescription());
        advert.setShortDescription(advert.getShortDescription());
        advert.setTitle(advertDto.getTitle());
        advertMapper.updateAdvert(advert);

        return ResponseEntity.ok().body(advertMapper.getById(advert.getId()));
    }

    @Override
    public ResponseEntity<?> deleteAdvert(Long advertId) {
        if (checkAccessToAdvert(advertId)){
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        advertMapper.deleteAdvertById(advertId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> archivedAdvert(Long advertId) {
        if (checkAccessToAdvert(advertId)){
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        advertMapper.archivedAdvert(advertId);

        return ResponseEntity.ok().body(advertMapper.getById(advertId));
    }

    private boolean checkAccessToAdvert(Long advertId) {
        User user = advertMapper.getUserByAdvertId(advertId);
        return user == null || !user.getId().equals(SecurityUtils.getLoggedUserId()) || (user.getCompanyId() != null && !user.getCompanyId().equals(SecurityUtils.getLoggedCompanyId()));
    }
}

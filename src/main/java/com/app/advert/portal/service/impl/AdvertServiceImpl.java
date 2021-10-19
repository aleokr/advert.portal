package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.dto.AdvertResponse;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.mapper.AdvertMapper;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.AdvertService;
import com.app.advert.portal.service.ApplicationService;
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

    private final ApplicationService applicationService;

    @Override
    public ResponseEntity<?> getById(Long id) {
        AdvertResponse advert = advertMapper.getAdvertInfoById(id);
        advert.setApplicationExists(applicationService.checkIfApplicationExists(id, SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId()));
        advert.setCanEdit(advert.getOwnerId().equals(SecurityUtils.getLoggedUserId()) || advert.getOwnerId().equals(SecurityUtils.getLoggedCompanyId()));
        advert.setCanApplicate(!advert.getApplicationExists() && !advert.getCanEdit()
                && ((advert.getAdvertType().equals(AdvertType.COMPANY) && !SecurityUtils.isCompanyUser()) || (advert.getAdvertType().equals(AdvertType.INDIVIDUAL) && SecurityUtils.isCompanyUser())));
        return ResponseEntity.ok().body(advert);
    }

    @Override
    public ResponseEntity<?> getAdverts(AdvertListRequest request) {
        return ResponseEntity.ok().body(advertMapper.getAdvertList(request));
    }

    @Override
    public ResponseEntity<?> saveAdvert(AdvertRequestDto advertRequestDto) {
        Advert advert = new Advert(null, advertRequestDto.getTitle(), advertRequestDto.getShortDescription(),
                advertRequestDto.getLongDescription(), SecurityUtils.getLoggedUserId(), advertRequestDto.getCategory(), SecurityUtils.getLoggedCompanyId() != null ? AdvertType.COMPANY : AdvertType.INDIVIDUAL);
        advertMapper.saveAdvert(advert);
        return ResponseEntity.ok().body(advertMapper.getById(advertMapper.lastAddAdvertId()));
    }

    @Override
    public ResponseEntity<?> updateAdvert(AdvertRequestDto advertDto) {

        if (noAccessToAdvert(advertDto.getId())) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        Advert advert = advertMapper.getById(advertDto.getId());
        advert.setLongDescription(advertDto.getLongDescription());
        advert.setShortDescription(advertDto.getShortDescription());
        advert.setTitle(advertDto.getTitle());
        advertMapper.updateAdvert(advert);

        return ResponseEntity.ok().body(advertMapper.getById(advert.getId()));
    }

    @Override
    public ResponseEntity<?> deleteAdvert(Long advertId) {
        if (noAccessToAdvert(advertId)) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        advertMapper.deleteAdvertById(advertId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> archivedAdvert(Long advertId) {
        if (noAccessToAdvert(advertId)) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        advertMapper.archivedAdvert(advertId);

        return ResponseEntity.ok().body(advertMapper.getById(advertId));
    }

    @Override
    public ResponseEntity<?> getAdvertCategories() {
        return ResponseEntity.ok().body(advertMapper.getAdvertCategories());
    }


    private boolean noAccessToAdvert(Long advertId) {
        if (advertId == null) return true;
        User user = advertMapper.getUserByAdvertId(advertId);
        return user == null || !user.getId().equals(SecurityUtils.getLoggedUserId()) || (user.getCompanyId() != null && !user.getCompanyId().equals(SecurityUtils.getLoggedCompanyId()));
    }
}

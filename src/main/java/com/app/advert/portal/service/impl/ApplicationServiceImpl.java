package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.mapper.ApplicationMapper;
import com.app.advert.portal.model.Application;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationMapper applicationMapper;

    @Override
    public ResponseEntity<?> getUserApplications(ApplicationListRequest request) {
        return ResponseEntity.ok().body(applicationMapper.getUserApplications(request, SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId()));
    }

    @Override
    public ResponseEntity<?> getResponsesToUserAdverts(ApplicationListRequest request) {
        return ResponseEntity.ok().body(applicationMapper.getResponsesToUserAdverts(request, SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId()));
    }

    @Override
    public ResponseEntity<?> saveResponseToAdvert(Long advertId) {
        if (applicationMapper.checkApplicationExists(advertId, SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId())) {
            return ResponseEntity.badRequest().body("Application already exists!");
        }
        Application application = new Application(null, advertId, SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId());
        applicationMapper.saveAdvert(application);
        return ResponseEntity.ok().build();
    }

    @Override
    public Boolean checkIfApplicationExists(Long advertId, Long companyId, Long userId) {
        return applicationMapper.checkApplicationExists(advertId, companyId, userId);
    }
}

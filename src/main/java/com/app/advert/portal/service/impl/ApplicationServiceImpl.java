package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationListResponse;
import com.app.advert.portal.dto.PagingResponse;
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
        ApplicationListResponse response = new ApplicationListResponse();

        Integer totalCount = applicationMapper.getApplicationsCountByUser(SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId());
        PagingResponse pagingResponse = new PagingResponse(request.getOffset()/request.getLimit(), (totalCount % request.getLimit() == 0) ? totalCount / request.getLimit() : totalCount / request.getLimit() + 1, totalCount);

        response.setApplications(applicationMapper.getUserApplications(request, SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId()));
        response.setPaging(pagingResponse);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> getResponsesToUserAdverts(ApplicationListRequest request) {
        ApplicationListResponse response = new ApplicationListResponse();

        Integer totalCount = applicationMapper.getResponsesCountByUser(SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId());
        PagingResponse pagingResponse = new PagingResponse(request.getOffset()/request.getLimit(), (totalCount % request.getLimit() == 0) ? totalCount / request.getLimit() : totalCount / request.getLimit() + 1, totalCount);

        response.setApplications(applicationMapper.getResponsesToUserAdverts(request, SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId()));
        response.setPaging(pagingResponse);
        return ResponseEntity.ok().body(response);
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

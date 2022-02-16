package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationListResponse;
import com.app.advert.portal.dto.PagingResponse;
import com.app.advert.portal.mapper.ApplicationMapper;
import com.app.advert.portal.model.Application;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationMapper applicationMapper;

    @Override
    public ApplicationListResponse getUserApplications(ApplicationListRequest request, Long companyId, Long userId) {
        ApplicationListResponse response = new ApplicationListResponse();

        Integer totalCount = applicationMapper.getApplicationsCountByUser(companyId, companyId != null ? null : userId);
        PagingResponse pagingResponse = new PagingResponse(request.getOffset()/request.getLimit(), (totalCount % request.getLimit() == 0) ? totalCount / request.getLimit() : totalCount / request.getLimit() + 1, totalCount);

        response.setApplications(applicationMapper.getUserApplications(request, companyId != null ? null : userId, companyId));
        response.setPaging(pagingResponse);
        return response;
    }

    @Override
    public ApplicationListResponse getResponsesToUserAdverts(ApplicationListRequest request, Long companyId, Long userId) {
        ApplicationListResponse response = new ApplicationListResponse();

        Integer totalCount = applicationMapper.getResponsesCountByUser(companyId, companyId != null ? null : userId);
        PagingResponse pagingResponse = new PagingResponse(request.getOffset()/request.getLimit(), (totalCount % request.getLimit() == 0) ? totalCount / request.getLimit() : totalCount / request.getLimit() + 1, totalCount);

        response.setApplications(applicationMapper.getResponsesToUserAdverts(request, SecurityUtils.getLoggedCompanyId() != null ? null : userId, companyId));
        response.setPaging(pagingResponse);
        return response;
    }

    @Override
    public Application saveResponseToAdvert(Long advertId, Long companyId, Long userId) {
        if (applicationMapper.checkApplicationExists(advertId, companyId != null ? null : userId, companyId)) {
            return null;
        }
        Application application = new Application(null, advertId, userId, companyId);
        applicationMapper.saveAdvert(application);
        return application;
    }

    @Override
    public Boolean checkIfApplicationExists(Long advertId, Long companyId, Long userId) {
        return applicationMapper.checkApplicationExists(advertId, userId, companyId);
    }
}

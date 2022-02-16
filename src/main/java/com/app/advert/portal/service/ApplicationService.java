package com.app.advert.portal.service;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationListResponse;
import com.app.advert.portal.model.Application;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationService {

    ApplicationListResponse getUserApplications(ApplicationListRequest request, Long companyId, Long userId);

    ApplicationListResponse getResponsesToUserAdverts(ApplicationListRequest request, Long companyId, Long userId);

    Application saveResponseToAdvert(Long advertId, Long companyId, Long userId);

    Boolean checkIfApplicationExists(Long advertId, Long companyId, Long userId);

}

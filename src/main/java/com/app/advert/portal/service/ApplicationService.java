package com.app.advert.portal.service;

import com.app.advert.portal.dto.ApplicationListRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationService {

    ResponseEntity<?> getUserApplications(ApplicationListRequest request);

    ResponseEntity<?> getResponsesToUserAdverts(ApplicationListRequest request);

    ResponseEntity<?> saveResponseToAdvert(Long advertId);

    Boolean checkIfApplicationExists(Long advertId, Long companyId, Long userId);

}

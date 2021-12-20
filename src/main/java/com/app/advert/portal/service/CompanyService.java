package com.app.advert.portal.service;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public interface CompanyService {

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> saveCompany(CompanyRequestDto companyDto) throws IOException;

    ResponseEntity<?> updateCompany(CompanyRequestDto companyDto);

    ResponseEntity<?> deleteCompany(Long companyId);

    ResponseEntity<?> companiesList(CompanyListRequest companyListRequest);

    ResponseEntity<?> getLoggedUserCompany();
}

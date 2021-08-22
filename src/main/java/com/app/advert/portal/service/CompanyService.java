package com.app.advert.portal.service;

import com.app.advert.portal.dto.CompanyRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface CompanyService {

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> saveCompany(CompanyRequestDto companyDto);

    ResponseEntity<?> updateCompany(CompanyRequestDto companyDto);

    ResponseEntity<?> deleteCompany(Long companyId);

    ResponseEntity<?> companiesList(CompanyRequestDto requestDto);

}

package com.app.advert.portal.service;

import com.app.advert.portal.dto.CompanyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface CompanyService {

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> saveCompany(CompanyDto companyDto);

    ResponseEntity<?> updateCompany(CompanyDto companyDto);

    ResponseEntity<?> deleteCompany(Long companyId);
}

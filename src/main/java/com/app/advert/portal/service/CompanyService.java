package com.app.advert.portal.service;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyRequestDto;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.model.Company;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public interface CompanyService {

    CompanyResponse getById(Long id);

    Company getBasicCompanyDataByName(String name);

    Company saveCompany(CompanyRequestDto companyDto, Long userId) throws IOException;

    Company updateCompany(CompanyRequestDto companyDto);

    void deleteCompany(Long companyId);

    List<CompanyResponse> companiesList(CompanyListRequest companyListRequest);

    CompanyResponse getLoggedUserCompany(Long companyId, boolean isAdmin);
}

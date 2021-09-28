package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyRequestDto;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.mapper.CompanyMapper;
import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    private final UserMapper userMapper;

    @Override
    public ResponseEntity<?> getById(Long id) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());
        if (user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.INDIVIDUAL_USER.name())) && !user.getCompanyId().equals(id) || !user.getActive()) {
            return ResponseEntity.badRequest().body("No access to resource");
        }
        return ResponseEntity.ok().body(companyMapper.getById(id));
    }

    @Override
    public ResponseEntity<?> saveCompany(CompanyRequestDto companyDto) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());

        if (user.getCompanyId() != null || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_ADMIN.name()))) {
            return ResponseEntity.badRequest().body("User has already a company or hasn't access to create a company");
        }
        if (companyMapper.getCompanyByName(companyDto.getName()) != null) {
            return ResponseEntity.unprocessableEntity().body("Company with name " + companyDto.getName() + " already exists");
        }

        Company company = new Company();
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
        companyMapper.saveCompany(company);
        company = companyMapper.getCompanyByName(company.getName());

        userMapper.addCompanyToUser(user.getId(), company.getId());

        return ResponseEntity.ok().body(company);
    }

    @Override
    public ResponseEntity<?> updateCompany(CompanyRequestDto companyDto) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());

        if (!user.getCompanyId().equals(companyDto.getId()) || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_USER.name()))) {
            return ResponseEntity.badRequest().body("No access to resource");
        }
        Company companyByName = companyMapper.getCompanyByName(companyDto.getName());
        if (companyByName != null && !companyByName.getId().equals(companyDto.getId())) {
            return ResponseEntity.unprocessableEntity().body("Company with name " + companyDto.getName() + " already exists");
        }

        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());

        companyMapper.updateCompany(company);

        return ResponseEntity.ok().body(companyMapper.getCompanyByName(company.getName()));
    }

    @Override
    public ResponseEntity<?> deleteCompany(Long companyId) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());

        if (user.getCompanyId() != companyId || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_USER.name()))) {
            return ResponseEntity.badRequest().body("No access to resource");
        }

        userMapper.deleteCompanyFromUsers(companyId);

        companyMapper.deleteCompanyById(companyId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> companiesList(CompanyListRequest companyListRequest) {
        Long limit = null;
        Long offset = null;
        if (companyListRequest.getOffset() != null && companyListRequest.getLimit() == null) {
            limit = 100L;
        }

        if (companyListRequest.getLimit() != null && companyListRequest.getOffset() == null) {
            offset = 0L;
        }

        CompanyListRequest request = CompanyListRequest.builder()
                .name(companyListRequest.getName())
                .limit(limit != null ? limit : companyListRequest.getLimit())
                .offset(offset != null ? offset : companyListRequest.getOffset())
                .build();
        return ResponseEntity.ok().body(companyMapper.getCompaniesList(request));
    }

    @Override
    public ResponseEntity<?> getLoggedUserCompany() {
        if (SecurityUtils.getLoggedCompanyId() == null) {
            return ResponseEntity.badRequest().body("No company id!");
        }
        CompanyResponse company = companyMapper.getLoggedUserCompany(SecurityUtils.getLoggedCompanyId());

        if (SecurityUtils.isUserCompanyAdmin()) {
            company.setRequestToJoin(companyMapper.getRequestToJoin(SecurityUtils.getLoggedCompanyId()));
        }
        return ResponseEntity.ok().body(company);
    }
}

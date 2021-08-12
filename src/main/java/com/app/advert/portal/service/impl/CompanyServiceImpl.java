package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.CompanyDto;
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
    public ResponseEntity getById(Long id) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());
        if (user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.INDIVIDUAL_USER.name())) && user.getCompanyId() != id) {
            return ResponseEntity.badRequest().body("No access to resource");
        }
        return ResponseEntity.ok().body(companyMapper.getById(id));
    }

    @Override
    public ResponseEntity saveCompany(CompanyDto companyDto) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());

        if (user.getCompanyId() != null || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_USER.name()))) {
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
    public ResponseEntity updateCompany(CompanyDto companyDto, Long companyId) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());

        if (!user.getCompanyId().equals(companyId) || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_USER.name()))) {
            return ResponseEntity.badRequest().body("No access to resource");
        }
        Company companyByName = companyMapper.getCompanyByName(companyDto.getName());
        if (companyByName != null && !companyByName.getId().equals(companyId)) {
            return ResponseEntity.unprocessableEntity().body("Company with name " + companyDto.getName() + " already exists");
        }

        Company company = new Company();
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());

        companyMapper.updateCompany(company, companyId);

        return ResponseEntity.ok().body(companyMapper.getCompanyByName(company.getName()));
    }

    @Override
    public ResponseEntity deleteCompany(Long companyId) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());

        if (user.getCompanyId() != companyId || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_USER.name()))) {
            return ResponseEntity.badRequest().body("No access to resource");
        }

        userMapper.deleteCompanyFromUsers(companyId);

        companyMapper.deleteCompanyById(companyId);
        return ResponseEntity.ok().build();
    }
}

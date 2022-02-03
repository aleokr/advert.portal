package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyRequestDto;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.dto.FileResponse;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.mapper.CompanyMapper;
import com.app.advert.portal.mapper.FileMapper;
import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.File;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    private final UserMapper userMapper;

    private final FileMapper fileMapper;

    private final FileService fileService;

    @Override
    public ResponseEntity<?> getById(Long id) {
        CompanyResponse companyResponse = companyMapper.getById(id);

        List<FileResponse> files = fileService.getFilesDataByResourceId(id, ResourceType.COMPANY);
        for (FileResponse fileResponse : files) {
            if (fileResponse.getFileType().equals(FileType.ATTACHMENT)) {
                companyResponse.setMainFilePath(fileResponse.getFilePath());
            } else {
                companyResponse.setImagePath(fileResponse.getFilePath());
            }
        }
        return ResponseEntity.ok().body(companyResponse);
    }

    @Override
    public ResponseEntity<?> saveCompany(CompanyRequestDto companyDto) throws IOException {
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

        if (!user.getCompanyId().equals(companyDto.getId()) || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_ADMIN.name()))) {
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
        //usunięcie plików przypisanych do firmy
        List<File> files = fileMapper.getFilesByResourceId(companyId, ResourceType.COMPANY);
        for (File file : files) {
            fileService.deleteFile(null, file);
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

        CompanyListRequest request = new CompanyListRequest(companyListRequest.getName(), limit != null ? limit : companyListRequest.getLimit(),
                offset != null ? offset : companyListRequest.getOffset());
        return ResponseEntity.ok().body(companyMapper.getCompaniesList(request));
    }

    @Override
    public ResponseEntity<?> getLoggedUserCompany() {
        if (SecurityUtils.getLoggedCompanyId() == null) {
            return ResponseEntity.badRequest().body("No company id!");
        }
        CompanyResponse company = companyMapper.getLoggedUserCompany(SecurityUtils.getLoggedCompanyId());
        List<FileResponse> files = fileService.getFilesDataByResourceId(company.getId(), ResourceType.COMPANY);
        for (FileResponse fileResponse : files) {
            if (fileResponse.getFileType().equals(FileType.ATTACHMENT)) {
                company.setMainFilePath(fileResponse.getFilePath());
            } else {
                company.setImagePath(fileResponse.getFilePath());
            }
        }
        if (SecurityUtils.isUserCompanyAdmin()) {
            company.setRequestToJoin(companyMapper.getRequestToJoin(SecurityUtils.getLoggedCompanyId()));
        }

        return ResponseEntity.ok().body(company);
    }
}

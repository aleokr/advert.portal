package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyRequestDto;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.dto.FileResponse;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.mapper.CompanyMapper;
import com.app.advert.portal.mapper.FileMapper;
import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.File;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public CompanyResponse getById(Long id) {
        CompanyResponse companyResponse = companyMapper.getById(id);

        List<FileResponse> files = fileService.getFilesDataByResourceId(id, ResourceType.COMPANY);
        for (FileResponse fileResponse : files) {
            if (fileResponse.getFileType().equals(FileType.ATTACHMENT)) {
                companyResponse.setMainFilePath(fileResponse.getFilePath());
            } else {
                companyResponse.setImagePath(fileResponse.getFilePath());
            }
        }
        return companyResponse;
    }

    @Override
    public Company getBasicCompanyDataByName(String name) {
        return companyMapper.getCompanyByName(name);
    }

    @Override
    public Company saveCompany(CompanyRequestDto companyDto, Long userId) {
        if (companyMapper.getCompanyByName(companyDto.getName()) != null) {
            return null;
        }
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
        companyMapper.saveCompany(company);
        company = companyMapper.getCompanyByName(company.getName());

        userMapper.addCompanyToUser(userId, company.getId());

        return company;
    }

    @Override
    public Company updateCompany(CompanyRequestDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());

        companyMapper.updateCompany(company);

        return companyMapper.getCompanyByName(company.getName());
    }

    @Override
    public void deleteCompany(Long companyId) {
        //usunięcie plików przypisanych do firmy
        List<File> files = fileMapper.getFilesByResourceId(companyId, ResourceType.COMPANY);
        for (File file : files) {
            fileService.deleteFile(null, file);
        }

        userMapper.deleteCompanyFromUsers(companyId);

        companyMapper.deleteCompanyById(companyId);
    }

    @Override
    public List<CompanyResponse> companiesList(CompanyListRequest companyListRequest) {
        Long limit = null;
        Long offset = null;
        if (companyListRequest.getOffset() != null && companyListRequest.getLimit() == null) {
            limit = 100L;
        }

        if (companyListRequest.getLimit() != null && companyListRequest.getOffset() == null) {
            offset = 0L;
        }

        CompanyListRequest request = new CompanyListRequest(companyListRequest.getName(), offset != null ? offset : companyListRequest.getOffset(), limit != null ? limit : companyListRequest.getLimit());
        return companyMapper.getCompaniesList(request);
    }

    @Override
    public CompanyResponse getLoggedUserCompany(Long companyId, boolean isAdmin) {
        CompanyResponse company = companyMapper.getLoggedUserCompany(companyId);
        List<FileResponse> files = fileService.getFilesDataByResourceId(company.getId(), ResourceType.COMPANY);
        for (FileResponse fileResponse : files) {
            if (fileResponse.getFileType().equals(FileType.ATTACHMENT)) {
                company.setMainFilePath(fileResponse.getFilePath());
            } else {
                company.setImagePath(fileResponse.getFilePath());
            }
        }
        if (isAdmin) {
            company.setRequestToJoin(companyMapper.getRequestToJoin(companyId));
        }

        return company;
    }
}

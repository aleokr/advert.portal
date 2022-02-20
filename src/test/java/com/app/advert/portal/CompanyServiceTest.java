package com.app.advert.portal;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyRequestDto;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/company-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class CompanyServiceTest {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Test
    public void saveAndGetCompanyById() throws IOException {
        //given
        User adminUser = userService.getByUsername("test_admin");

        Company company = companyService.saveCompany(new CompanyRequestDto(null, "Dunder mifflin", "Paper company"), adminUser.getId());

        //when
        CompanyResponse companyById = companyService.getById(company.getId());

        //then
        assertNotNull(companyById);
        assertEquals(companyById.getId(), company.getId());
        assertEquals(companyById.getName(), company.getName());
        assertEquals(companyById.getDescription(), company.getDescription());
        assertEquals(companyById.getMembers().size(), 1);
        assertNull(companyById.getImagePath());
        assertNull(companyById.getMainFilePath());
        assertNull(companyById.getRequestToJoin());

    }

    @Test
    public void updateCompany() throws IOException {
        //given
        User adminUser = userService.getByUsername("test_admin");

        Company company = companyService.saveCompany(new CompanyRequestDto(null, "Dunder mifflin 2.0", "Paper company"), adminUser.getId());

        //when
        companyService.updateCompany(new CompanyRequestDto(company.getId(), "Dunder mifflin Inc", "Paper company from Scranton"));

        CompanyResponse updatedCompany = companyService.getById(company.getId());

        //then
        assertNotNull(updatedCompany);
        assertEquals(updatedCompany.getId(), company.getId());
        assertEquals(company.getName(), "Dunder mifflin 2.0");
        assertEquals(updatedCompany.getName(), "Dunder mifflin Inc");
        assertEquals(company.getDescription(), "Paper company");
        assertEquals(updatedCompany.getDescription(), "Paper company from Scranton");
        assertEquals(updatedCompany.getMembers().size(), 1);
    }

    @Test
    public void deleteCompany() throws IOException {
        //given
        User adminUser = userService.getByUsername("test_admin");

        Company company = companyService.saveCompany(new CompanyRequestDto(null, "Dunder mifflin 3.0", "Paper company"), adminUser.getId());

        //when
        companyService.deleteCompany(company.getId());

        Company deletedCompany = companyService.getBasicCompanyDataByName("Dunder mifflin 3.0");

        //then
        assertNull(deletedCompany);
    }

    @Test
    public void deleteCompanyWithFiles() {
        //given
        Company company = companyService.getBasicCompanyDataByName("File company");

        //when
        companyService.deleteCompany(company.getId());

        Company deletedCompany = companyService.getBasicCompanyDataByName("File company");

        //then
        assertNull(deletedCompany);
    }

    @Test
    public void getCompanyWithFilesById() {
        //given
        Company company = companyService.getBasicCompanyDataByName("File company 2");

        //when
        CompanyResponse companyResponse = companyService.getById(company.getId());

        //then
        assertNotNull(companyResponse);
        assertEquals(companyResponse.getName(), "File company 2");
        assertEquals(companyResponse.getDescription(), "File company description");
        assertEquals(companyResponse.getMembers().size(), 0);
        assertNull(companyResponse.getRequestToJoin());
        assertNotNull(companyResponse.getImagePath());
        assertNotNull(companyResponse.getMainFilePath());
    }

    @Test
    public void getCompaniesListByName() {
        //when
        List<CompanyResponse> companies = companyService.companiesList(new CompanyListRequest("Test", null, null));

        //then
        assertNotNull(companies);
        assertEquals(companies.size(), 4);
    }

    @Test
    public void getCompaniesListByNameWithPaging() {
        //when
        List<CompanyResponse> companies = companyService.companiesList(new CompanyListRequest("Test", 0L, 2L));
        List<CompanyResponse> companies2 = companyService.companiesList(new CompanyListRequest("Test", 3L, 2L));

        //then
        assertNotNull(companies);
        assertEquals(companies.size(), 2);
        assertNotNull(companies2);
        assertEquals(companies2.size(), 1);
    }

    @Test
    public void getLoggedAdminCompanyData() {
        //given
        Company company = companyService.getBasicCompanyDataByName("Logged user data");

        //when
        CompanyResponse companyData = companyService.getLoggedUserCompany(company.getId(), true);

        //then
        assertNotNull(companyData);
        assertEquals(companyData.getName(), "Logged user data");
        assertEquals(companyData.getDescription(), "Test logged user data description");
        assertEquals(companyData.getMembers().size(), 2);
        assertEquals(companyData.getRequestToJoin().size(), 1);
        assertNotNull(companyData.getImagePath());
        assertNotNull(companyData.getMainFilePath());
    }

    @Test
    public void getLoggedCompanyUserCompanyData() {
        //given
        Company company = companyService.getBasicCompanyDataByName("Logged user data");

        //when
        CompanyResponse companyData = companyService.getLoggedUserCompany(company.getId(), false);

        //then
        assertNotNull(companyData);
        assertEquals(companyData.getName(), "Logged user data");
        assertEquals(companyData.getDescription(), "Test logged user data description");
        assertEquals(companyData.getMembers().size(), 2);
        assertNull(companyData.getRequestToJoin());
        assertNotNull(companyData.getImagePath());
        assertNotNull(companyData.getMainFilePath());
    }
}

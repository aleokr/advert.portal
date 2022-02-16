package com.app.advert.portal;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationResponse;
import com.app.advert.portal.model.Application;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.ApplicationService;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/application-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class ApplicationServiceTest {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Test
    public void getUserApplications() {
        //given
        User user = userService.getByUsername("test_individual");

        //when
        List<ApplicationResponse> applications = applicationService.getUserApplications(new ApplicationListRequest(100, 0), null, user.getId()).getApplications();

        //then
        assertNotNull(applications);
        assertEquals(applications.size(), 1);
        assertEquals(applications.get(0).getAdvertTitle(), "Advert Company 2");
    }

    @Test
    public void getCompanyApplications() {
        //given
        User user = userService.getByUsername("test_company");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        List<ApplicationResponse> applications = applicationService.getUserApplications(new ApplicationListRequest(100, 0), company.getId(), user.getId()).getApplications();

        //then
        assertNotNull(applications);
        assertEquals(applications.size(), 2);
        assertTrue(applications.stream().map(ApplicationResponse::getAdvertTitle).collect(Collectors.toList()).contains("Advert User 1"));
        assertTrue(applications.stream().map(ApplicationResponse::getAdvertTitle).collect(Collectors.toList()).contains("Advert User 2"));
    }

    @Test
    public void getUserResponses() {
        //given
        User user = userService.getByUsername("test_individual");

        //when
        List<ApplicationResponse> applications = applicationService.getResponsesToUserAdverts(new ApplicationListRequest(100, 0), null, user.getId()).getApplications();

        //then
        assertNotNull(applications);
        assertEquals(applications.size(), 2);
        assertTrue(applications.stream().map(ApplicationResponse::getAdvertTitle).collect(Collectors.toList()).contains("Advert User 1"));
        assertTrue(applications.stream().map(ApplicationResponse::getAdvertTitle).collect(Collectors.toList()).contains("Advert User 2"));
    }

    @Test
    public void getCompanyResponses() {
        //given
        User user = userService.getByUsername("test_company");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        List<ApplicationResponse> applications = applicationService.getResponsesToUserAdverts(new ApplicationListRequest(100, 0), company.getId(), user.getId()).getApplications();

        //then
        assertNotNull(applications);
        assertEquals(applications.size(), 1);
        assertTrue(applications.stream().map(ApplicationResponse::getAdvertTitle).collect(Collectors.toList()).contains("Advert Company 2"));
    }

    @Test
    public void saveResponseToAdvert() {
        //given
        User individualUser = userService.getByUsername("test_individual3");
        User companyUser = userService.getByUsername("test_admin2");
        Company company = companyService.getBasicCompanyDataByName("Test company2");

        List<ApplicationResponse> applications = applicationService.getResponsesToUserAdverts(new ApplicationListRequest(100, 0), company.getId(), companyUser.getId()).getApplications();

        //when

        Application application = applicationService.saveResponseToAdvert(applications.get(0).getAdvertId(), null, individualUser.getId());

        assertNotNull(application);
        assertTrue(applicationService.checkIfApplicationExists(applications.get(0).getAdvertId(), null, individualUser.getId()));
    }

    @Test
    public void tryToSaveResponseWhenApplicationAlreadyExists() {
        //given
        User individualUser = userService.getByUsername("test_individual");
        User companyUser = userService.getByUsername("test_company");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        List<ApplicationResponse> applications = applicationService.getResponsesToUserAdverts(new ApplicationListRequest(100, 0), company.getId(), companyUser.getId()).getApplications();

        //when

        Application application = applicationService.saveResponseToAdvert(applications.get(0).getAdvertId(), null, individualUser.getId());

        assertNull(application);

    }
}

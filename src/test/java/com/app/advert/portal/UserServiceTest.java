package com.app.advert.portal;

import com.app.advert.portal.dto.UserRequestDto;
import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.Permission;
import com.app.advert.portal.model.Role;
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
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/user-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;


    @Test
    public void addUser() throws IOException {
        //given
        UserRequestDto userRequest = new UserRequestDto(null, "Jim", "Halpert", "jim@dundermifflin.com", "addUser", "john123!", UserRole.INDIVIDUAL_USER, null);

        //when
        User user = userService.saveUser(userRequest);
        List<String> names = user.getRoles().get(0).getPermissions().stream().map(Permission::getName).collect(Collectors.toList());
        //then
        assertNotNull(user);
        assertEquals(user.getName(), "Jim");
        assertEquals(user.getSurname(), "Halpert");
        assertEquals(user.getLogin(), "addUser");
        assertEquals(user.getEmail(), "jim@dundermifflin.com");
        assertTrue(user.getActive());
        assertEquals(user.getRoles().size(), 1);
        assertEquals(names.size(), 3);
        assertTrue(names.contains("USER_READ"));
        assertTrue(names.contains("USER_WRITE"));
        assertTrue(names.contains("COMPANY_READ"));
    }


    @Test
    public void updateUser() throws IOException {
        //given
        User user = userService.saveUser(new UserRequestDto(null, "Jim", "Halpert", "jim@dundermifflin.com", "updateUser", "maj123!", UserRole.INDIVIDUAL_USER, null));
        if (user == null) {
            return;
        }
        UserRequestDto userRequest = new UserRequestDto(user.getId(), "Micheal", "Scott", "micheal@dundermifflin.com", "updateUser", "maj123!", UserRole.INDIVIDUAL_USER, null);

        //when
        User updatedUser = userService.updateUser(userRequest);

        //then

        assertNotNull(user);
        assertEquals(user.getName(), "Jim");
        assertEquals(user.getSurname(), "Halpert");
        assertEquals(user.getLogin(), "updateUser");
        assertEquals(user.getEmail(), "jim@dundermifflin.com");
        assertTrue(user.getActive());


        assertNotNull(updatedUser);
        assertEquals(updatedUser.getName(), "Micheal");
        assertEquals(updatedUser.getSurname(), "Scott");
        assertEquals(updatedUser.getLogin(), "updateUser");
        assertEquals(updatedUser.getEmail(), "micheal@dundermifflin.com");
        assertTrue(updatedUser.getActive());
    }

    @Test
    public void deleteUser() throws IOException {
        //given
        User user = userService.saveUser( new UserRequestDto(null, "Jim", "Halpert", "jim@dundermifflin.com",  "deleteUser", "maj123!", UserRole.INDIVIDUAL_USER, null));
        assertNotNull(user);
        //when
        userService.deleteUser(user.getId());
        User userAfterDelete = userService.getBasicUserDataById(user.getId());

        //then
        assertNull(userAfterDelete);
    }

    @Test
    public void deleteUserWithFiles() {
        //given
        User user = userService.getByUsername("test_file");
        //when
        userService.deleteUser(user.getId());
        User userAfterDelete = userService.getBasicUserDataById(user.getId());

        //then
        assertNull(userAfterDelete);
    }

    @Test
    public void activateUser() throws IOException {
        //given
        Company company = companyService.getBasicCompanyDataByName("Test company");
        User createdUser = userService.saveUser(new UserRequestDto(null, "Pam", "Beesly", "pam@dundermifflin.com", "activateUser", "pam123!", UserRole.COMPANY_USER, company.getId()));

        //when
        userService.activateUser(createdUser.getId());
        User activeUser = userService.getByUsername("activateUser");

        //then
        assertFalse(createdUser.getActive());
        assertTrue(activeUser.getActive());
    }

    @Test
    public void getUserRoles() {
        List<Role> roles = userService.getUserRoles();

        List<String> names = roles.stream().map(Role::getName).collect(Collectors.toList());
        assertTrue(names.contains("COMPANY_ADMIN"));
        assertTrue(names.contains("COMPANY_USER"));
        assertTrue(names.contains("INDIVIDUAL_USER"));
    }

    @Test
    public void getUserWithAdditionalInfoAboutCompanyUsers() {
        //given
        User companyUser = userService.getByUsername("test_company");
        User companyAdmin = userService.getByUsername("test_admin");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        UserResponse companyUserResponse = userService.getById(companyUser.getId(), company.getId());
        UserResponse companyAdminResponse = userService.getById(companyAdmin.getId(), company.getId());

        //then
        assertEquals(companyUserResponse.getName(), "Company");
        assertEquals(companyAdminResponse.getName(), "Company");

        assertEquals(companyUserResponse.getSurname(), "User");
        assertEquals(companyAdminResponse.getSurname(), "Admin");

        assertEquals(companyUserResponse.getEmail(), "company@test.com");
        assertEquals(companyAdminResponse.getEmail(), "admin@test.com");


        assertEquals(companyUserResponse.getLogin(), "test_company");
        assertEquals(companyAdminResponse.getLogin(), "test_admin");

        assertEquals(companyUserResponse.getCompanyId(), companyAdminResponse.getCompanyId());
        assertEquals(companyUserResponse.getCompanyId(), company.getId());

        assertEquals(companyUserResponse.getActive(), companyAdminResponse.getActive());
        assertTrue(companyUserResponse.getActive());

        assertEquals(companyUserResponse.getType(), UserRole.COMPANY_USER);
        assertEquals(companyAdminResponse.getType(), UserRole.COMPANY_ADMIN);

        assertEquals(companyUserResponse.getAdvertsCount(), companyAdminResponse.getAdvertsCount());
        assertEquals(companyUserResponse.getAdvertsCount(), 3);

        assertEquals(companyUserResponse.getResponsesCount(), companyAdminResponse.getResponsesCount());
        assertEquals(companyUserResponse.getResponsesCount(), 1);

        assertEquals(companyUserResponse.getApplicationsCount(), companyAdminResponse.getApplicationsCount());
        assertEquals(companyUserResponse.getApplicationsCount(), 2);

        assertEquals(companyUserResponse.getTags(), companyAdminResponse.getTags());
        assertEquals(companyUserResponse.getTags().size(), 0);

        assertEquals(companyUserResponse.getImagePath(), companyAdminResponse.getImagePath());

        assertEquals(companyUserResponse.getMainFilePath(), companyAdminResponse.getMainFilePath());
    }

    @Test
    public void getUserWithAdditionalInfoAboutIndividualUser() {
        //given
        User individualUser = userService.getByUsername("test_Individual");

        //when
        UserResponse individualUserResponse = userService.getLoggedUserInfo(null, individualUser.getId());

        //then
        assertEquals(individualUserResponse.getName(), "Individual");

        assertEquals(individualUserResponse.getSurname(), "User");

        assertEquals(individualUserResponse.getEmail(), "individual@test.com");

        assertEquals(individualUserResponse.getLogin(), "test_Individual");

        assertNull(individualUserResponse.getCompanyId());

        assertTrue(individualUserResponse.getActive());

        assertEquals(individualUserResponse.getType(), UserRole.INDIVIDUAL_USER);

        assertEquals(individualUserResponse.getAdvertsCount(), 2);

        assertEquals(individualUserResponse.getResponsesCount(), 2);

        assertEquals(individualUserResponse.getApplicationsCount(), 1);

        assertEquals(individualUserResponse.getTags().size(), 0);

        assertNull(individualUserResponse.getImagePath());

        assertNull(individualUserResponse.getMainFilePath());
    }
}

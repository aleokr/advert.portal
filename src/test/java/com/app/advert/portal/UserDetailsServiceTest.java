package com.app.advert.portal;

import com.app.advert.portal.dto.UserRequestDto;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.security.UserPrincipal;
import com.app.advert.portal.service.UserService;
import com.app.advert.portal.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class UserDetailsServiceTest {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserService userService;

    @Test
    public void loadUserByUsername() throws IOException {
        //given
        UserRequestDto userRequest = new UserRequestDto(null, "Jim", "Halpert", "jim@dundermifflin.com", "exist", "john123!", UserRole.INDIVIDUAL_USER, null);
        userService.saveUser(userRequest);

        //when
        UserPrincipal userDetails = (UserPrincipal) userDetailsService.loadUserByUsername("exist");

        //then
        assertNotNull(userDetails);
        assertEquals(userDetails.getAuthorities().size(), 4);
    }

    @Test
    public void loadUserByUsernameWhereUserNotExists(){
        //when
        UsernameNotFoundException thrown = Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("not_existing_username");
        });

        //then
        assertEquals("User not found!", thrown.getMessage());
    }
}

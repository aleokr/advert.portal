package com.app.advert.portal;

import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.dto.AdvertListResponse;
import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertResponse;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.Tag;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.AdvertService;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.TagService;
import com.app.advert.portal.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/advert-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
@ActiveProfiles("test")
@SpringBootTest
public class AdvertServiceTest {

    @Autowired
    AdvertService advertService;

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Test
    public void saveAdvert() throws IOException {
        //given
        User user = userService.getByUsername("test_individual");
        Tag tag = tagService.saveTag("INDIVIDUAL", null, user.getId());

        List<Long> tagIds = new ArrayList<>();
        tagIds.add(tag.getId());

        //when
        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, tagIds), null, user.getId());

        AdvertResponse advertResponse = advertService.getById(advert.getId(), null, user.getId());

        //then
        assertNotNull(advertResponse);
        assertEquals(advertResponse.getTitle(), "Advert title");
        assertEquals(advertResponse.getShortDescription(), "Short advert description");
        assertEquals(advertResponse.getLongDescription(), "Long advert description");
        assertEquals(advertResponse.getAdvertCategory(), AdvertCategory.ADMINISTRATION);
        assertFalse(advertResponse.isArchived());
        assertFalse(advertResponse.getApplicationExists());
        assertEquals(advertResponse.getOwnerId(), user.getId());
        assertEquals(advertResponse.getAdvertType(), AdvertType.INDIVIDUAL);
        assertEquals(advertResponse.getTags().size(), 1);
    }

    @Test
    public void updateAdvert() throws IOException {
        //given
        User user = userService.getByUsername("test_admin_ad");
        Company company = companyService.getBasicCompanyDataByName("Test company");
        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), company.getId(), user.getId());

        //when
        advertService.updateAdvert(new AdvertRequestDto(advert.getId(), "New advert title", "New short advert description",
                "New long advert description", null, null),
                company.getId(), user.getId());

        AdvertResponse advertResponse = advertService.getById(advert.getId(), company.getId(), user.getId());

        //then
        assertNotNull(advertResponse);
        assertEquals(advertResponse.getTitle(), "New advert title");
        assertEquals(advertResponse.getShortDescription(), "New short advert description");
        assertEquals(advertResponse.getLongDescription(), "New long advert description");
    }

    @Test
    public void updateAdvertWithNoAccess() throws IOException {
        //given
        User user = userService.getByUsername("test_admin_ad");
        Company company = companyService.getBasicCompanyDataByName("Test company");
        User individualUser = userService.getByUsername("test_individual");
        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), company.getId(), user.getId());

        //when
        Advert updatedAdvert = advertService.updateAdvert(new AdvertRequestDto(advert.getId(), "New advert title", "New short advert description",
                        "New long advert description", null, null),
                null, individualUser.getId());

        //then
        assertNull(updatedAdvert);
    }

    @Test
    public void deleteAdvert() throws IOException {
        User user = userService.getByUsername("test_individual");

        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), null, user.getId());


        //when
        advertService.deleteAdvert(advert.getId(), null, user.getId());

        AdvertResponse advertResponse = advertService.getById(advert.getId(), null, user.getId());

        //then
        assertNull(advertResponse);
    }

    @Test
    public void archivedAdvert() throws IOException {
        User user = userService.getByUsername("test_individual");

        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), null, user.getId());

        //when
        advertService.archivedAdvert(advert.getId(), null, user.getId());

        AdvertResponse advertResponse = advertService.getById(advert.getId(), null, user.getId());

        //then
        assertNotNull(advertResponse);
        assertTrue(advertResponse.isArchived());
    }
    @Test
    public void deleteWithNoAccess() throws IOException {
        User user = userService.getByUsername("test_individual");

        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), null, user.getId());

        //when
        advertService.deleteAdvert(advert.getId(), null, user.getId() + 1 );

        AdvertResponse advertResponse = advertService.getById(advert.getId(), null, user.getId());

        //then
        assertNotNull(advertResponse);

    }

    @Test
    public void deleteWithFile() throws IOException {
        //given
        User user = userService.getByUsername("test_individual");

        AdvertListResponse list = advertService.getAdverts(new AdvertListRequest(AdvertType.INDIVIDUAL, 0, 100), null, user.getId());
        AdvertResponse advertWithFIle = list.getAdverts().stream().filter(a -> a.getTitle().equals("Advert User 1")).findFirst().orElse(null);

        //when
        AdvertResponse advertResponse = advertService.getById(advertWithFIle.getId(), null, user.getId());

        advertService.deleteAdvert(advertWithFIle.getId(), null, user.getId());
        AdvertResponse deletedAdvertResponse = advertService.getById(advertWithFIle.getId(), null, user.getId());
        //then
        assertNotNull(advertResponse);
        assertNull(deletedAdvertResponse);

    }

    @Test
    public void archiveWithNoAccess() throws IOException {
        User user = userService.getByUsername("test_individual");

        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), null, user.getId());


        //when
        advertService.archivedAdvert(advert.getId(), null, user.getId() + 1);

        AdvertResponse advertResponse = advertService.getById(advert.getId(), null, user.getId());

        //then
        assertNotNull(advertResponse);
        assertFalse(advertResponse.isArchived());

    }

    @Test
    public void getAdverts() throws IOException {

        //given
        User user = userService.getByUsername("test_admin_ad");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        AdvertListResponse list = advertService.getAdverts(new AdvertListRequest(AdvertType.INDIVIDUAL, 0, 100), company.getId(), user.getId());

        //then
        assertNotNull(list);

        List<AdvertResponse> advertList = list.getAdverts();
        assertNotNull(advertList.stream().filter(a -> a.getTitle().equals("Advert User 1")).findFirst().orElse(null));
        assertNotNull(advertList.stream().filter(a -> a.getTitle().equals("Advert User 2")).findFirst().orElse(null));
        assertTrue(advertList.size() >= 2);
;
    }

    @Test
    public void getAdvertsWithNoType() throws IOException {

        //given
        User user = userService.getByUsername("test_admin_ad");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        AdvertListResponse list = advertService.getAdverts(new AdvertListRequest(null, 0, 100), company.getId(), user.getId());

        //then
        assertNotNull(list);

        List<AdvertResponse> advertList = list.getAdverts();
        assertNotNull(advertList.stream().filter(a -> a.getTitle().equals("Advert Company 1")).findFirst().orElse(null));
        assertTrue(advertList.size() >= 1);
    }

    @Test
    public void getAdvertsWithSimilarFiles() throws IOException {

        //given
        User user = userService.getByUsername("test_admin_ad");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        AdvertListResponse list = advertService.getAdverts(new AdvertListRequest(null, null, null, 0, 100, AdvertType.COMPANY, null, true), company.getId(), user.getId());

        //then
        assertNotNull(list);

        List<AdvertResponse> advertList = list.getAdverts();
        assertEquals(advertList.size(), 0);
    }

    @Test
    public void getAdvertsByText() throws IOException {

        //given
        User user = userService.getByUsername("test_admin_ad");
        Company company = companyService.getBasicCompanyDataByName("Test company");
        advertService.saveAdvert(new AdvertRequestDto(null, "Awesome advert title", "Short advert description", "Awesome long advert description",
                AdvertCategory.ADMINISTRATION, null), company.getId(), user.getId());
        //when
        AdvertListResponse list = advertService.getAdverts(new AdvertListRequest(null, null, null, 0, 100, AdvertType.COMPANY, "Awesome",  false), company.getId(), user.getId());

        //then
        assertNotNull(list);

        List<AdvertResponse> advertList = list.getAdverts();
        assertNotNull(advertList.stream().filter(a -> a.getTitle().equals("Awesome advert title")).findFirst().orElse(null));
        assertTrue(advertList.size() > 0);
    }

    @Test
    public void getAdvertCategories() {
        //when
        List<AdvertCategory> categories = advertService.getAdvertCategories();

        //then
        assertNotNull(categories);
        assertTrue(categories.contains(AdvertCategory.ADMINISTRATION));
        assertTrue(categories.contains(AdvertCategory.ARCHITECTURE));
        assertTrue(categories.contains(AdvertCategory.BIOLOGY));
        assertTrue(categories.contains(AdvertCategory.CHEMISTRY));
        assertTrue(categories.contains(AdvertCategory.COMPUTER_SCIENCE));
        assertTrue(categories.contains(AdvertCategory.ELECTRONICS));
        assertTrue(categories.contains(AdvertCategory.JOURNALISM));
        assertTrue(categories.contains(AdvertCategory.MANAGEMENT));
        assertTrue(categories.contains(AdvertCategory.MATHEMATICS));
        assertTrue(categories.contains(AdvertCategory.OTHER));
        assertTrue(categories.contains(AdvertCategory.PHYSICS));
        assertTrue(categories.contains(AdvertCategory.TRANSPORT));
    }
}

package com.app.advert.portal;

import com.app.advert.portal.dto.ResourceTagRequestDto;
import com.app.advert.portal.dto.TagResponse;
import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.Tag;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.TagService;
import com.app.advert.portal.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/tag-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class TagServiceTest {

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Test
    public void saveTag() {
        //given
        User user = userService.getByUsername("test_Individual");

        //when
        Tag tag = tagService.saveTag("INDIVIDUAL", null, user.getId());
        UserResponse userResponse = userService.getById(user.getId(), null);

        //then
        assertNotNull(tag);
        assertNotNull(tag.getId());
        assertEquals(tag.getName(), "individual");
        assertEquals(userResponse.getTags().size(), 1);
        assertTrue(userResponse.getTags().stream().map(Tag::getName).collect(Collectors.toList()).contains("individual"));
    }

    @Test
    public void saveTagByCompany() {
        //given
        User user = userService.getByUsername("test_admin");
        Company company = companyService.getBasicCompanyDataByName("Test company");

        //when
        Tag tag = tagService.saveTag("COMPANY", company.getId(), user.getId());
        UserResponse userResponse = userService.getById(user.getId(), company.getId());

        //then
        assertNotNull(tag);
        assertNotNull(tag.getId());
        assertEquals(tag.getName(), "company");
        assertEquals(userResponse.getTags().size(), 1);
        assertTrue(userResponse.getTags().stream().map(Tag::getName).collect(Collectors.toList()).contains("company"));
    }

    @Test
    public void saveResourceTagToIndividualUser() {
        //given
        User user = userService.getByUsername("tag_Individual");
        TagResponse tag = tagService.getTagsList(1, 0).get(0);
        List<Long> tagIds = new ArrayList<>();
        tagIds.add(tag.getId());

        //when
        tagService.saveResourceTag(new ResourceTagRequestDto(tagIds, user.getId().intValue(), ResourceType.USER), null, user.getId());
        UserResponse userResponse = userService.getById(user.getId(), null);

        //then
        assertEquals(userResponse.getTags().size(), 1);
        assertTrue(userResponse.getTags().stream().map(Tag::getName).collect(Collectors.toList()).contains(tag.getName()));
    }

    @Test
    public void saveResourceTagToCompanyUser() {
        //given
        User user = userService.getByUsername("test_company_tag");
        Company company = companyService.getBasicCompanyDataByName("Tag company");
        TagResponse tag = tagService.getTagsList(1, 0).get(0);
        List<Long> tagIds = new ArrayList<>();
        tagIds.add(tag.getId());

        //when
        tagService.saveResourceTag(new ResourceTagRequestDto(tagIds, user.getId().intValue(), ResourceType.USER), company.getId(), user.getId());
        UserResponse userResponse = userService.getById(user.getId(), company.getId());

        //then
        assertEquals(userResponse.getTags().size(), 1);
        assertTrue(userResponse.getTags().stream().map(Tag::getName).collect(Collectors.toList()).contains(tag.getName()));
    }

    @Test
    public void getAvailableTagsByUser() {
        //given
        User user = userService.getByUsername("tag_Individual2");

        //when
        List<TagResponse> tags = tagService.getAvailableTagsList(null, user.getId());

        //then
        assertNotNull(tags);
        assertTrue(tags.stream().map(TagResponse::getName).collect(Collectors.toList()).contains("test1"));
        assertTrue(tags.stream().map(TagResponse::getName).collect(Collectors.toList()).contains("test2"));
        assertTrue(tags.stream().map(TagResponse::getName).collect(Collectors.toList()).contains("test3"));
    }

    @Test
    public void getAvailableTagsByCompany() {
        //given
        User user = userService.getByUsername("test_company_tag2");
        Company company = companyService.getBasicCompanyDataByName("Tag company2");

        //when
        List<TagResponse> tags = tagService.getAvailableTagsList(company.getId(), user.getId());

        //then
        assertNotNull(tags);
        assertTrue(tags.stream().map(TagResponse::getName).collect(Collectors.toList()).contains("test1"));
        assertTrue(tags.stream().map(TagResponse::getName).collect(Collectors.toList()).contains("test2"));
        assertTrue(tags.stream().map(TagResponse::getName).collect(Collectors.toList()).contains("test3"));
    }
}

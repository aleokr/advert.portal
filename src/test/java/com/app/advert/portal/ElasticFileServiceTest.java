package com.app.advert.portal;

import com.app.advert.portal.dto.AdvertListElasticResponse;
import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.elasticsearch.service.ElasticFileService;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.File;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.AdvertService;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.FileService;
import com.app.advert.portal.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/esfile-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
@ActiveProfiles("test")
@SpringBootTest
public class ElasticFileServiceTest {

    @Autowired
    ElasticFileService elasticFileService;

    @Autowired
    FileService fileService;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    AdvertService advertService;

    @Test
    public void saveFile() throws IOException {
        User user = userService.getByUsername("test_individual_file_es");
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);
        FileDto fileDto = new FileDto(null, multipartFile, "Test file", "attachment/pdf", FileType.ATTACHMENT, user.getId(), ResourceType.USER);

        File file = fileService.saveFile(fileDto);

        com.app.advert.portal.elasticsearch.document.File esFile = elasticFileService.getFileById(file.getId());

        assertNotNull(esFile);
        assertEquals(esFile.getName(), "Test file");
        assertEquals(esFile.getResourceId(), user.getId());
        assertEquals(esFile.getResourceType(), ResourceType.USER.name());
        assertNotNull(esFile.getData());
    }

    @Test
    public void findSimilarFile() throws IOException {
        //given
        User user = userService.getByUsername("test_admin_file");
        Company company = companyService.getBasicCompanyDataByName("Test company_file");
        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), company.getId(), user.getId());
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("advert.pdf", inputStream);

        fileService.saveFile(new FileDto(null, multipartFile, "Advert file", "attachment/pdf", FileType.ATTACHMENT, advert.getId(), ResourceType.ADVERT));

        User individualUser = userService.getByUsername("test_individual_file_es");
        InputStream inputStream2 = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile2 = new MockMultipartFile("user.pdf", inputStream2);
        FileDto fileDto = new FileDto(null, multipartFile2, "User file", "attachment/pdf", FileType.ATTACHMENT, individualUser.getId(), ResourceType.USER);

        File file = fileService.saveFile(fileDto);

        com.app.advert.portal.elasticsearch.document.File esFile = elasticFileService.getFileById(file.getId());

        //when
        AdvertListElasticResponse similarFiles = elasticFileService.findSimilarFile(esFile, AdvertType.COMPANY, 0, 100);

        //then

        assertNotNull(similarFiles);
        assertTrue(similarFiles.getAdvertIds().contains(advert.getId()));
    }
}

package com.app.advert.portal;

import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.dto.FileResponse;
import com.app.advert.portal.enums.AdvertCategory;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/file-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class FileServiceTest {

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
        //given
        User user = userService.getByUsername("test_individual_file");
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);
        FileDto fileDto = new FileDto(null, multipartFile, "Test file", "attachment/pdf", FileType.ATTACHMENT, user.getId(), ResourceType.USER);

        //when
        File file = fileService.saveFile(fileDto);

        assertNotNull(file);
        assertEquals(file.getName(), "Test file");
        assertNotNull(file.getS3Key());
        assertEquals(file.getContentType(), "attachment/pdf");
        assertEquals(file.getType(), FileType.ATTACHMENT);
        assertEquals(file.getResourceId(), user.getId());
        assertEquals(file.getResourceType(), ResourceType.USER);

        fileService.deleteFile(null, file);
    }

    @Test
    public void updateFile() throws IOException {
        //given
        Company company = companyService.getBasicCompanyDataByName("Test company2");
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);

        File file = fileService.saveFile(new FileDto(null, multipartFile, "Test file", "attachment/pdf", FileType.ATTACHMENT, company.getId(), ResourceType.COMPANY));


        InputStream inputStream2 = this.getClass().getResourceAsStream("/files/test2.pdf");
        MultipartFile multipartFile2 = new MockMultipartFile("test.pdf", inputStream2);
        //when
        FileDto fileDto = new FileDto(file.getId(), multipartFile2, "Test updated file", "attachment/pdf", FileType.ATTACHMENT, company.getId(), ResourceType.COMPANY);
        File updatedFile = fileService.saveFile(fileDto);

        assertNotNull(updatedFile);

        assertEquals(file.getName(), "Test file");
        assertEquals(updatedFile.getName(), "Test updated file");

        assertNotEquals(file.getS3Key(), updatedFile.getS3Key());

        fileService.deleteFile(updatedFile.getId(), null);
    }

    @Test
    public void deleteFile() throws IOException {
        //given
        User user = userService.getByUsername("test_admin");
        Company company = companyService.getBasicCompanyDataByName("Test company1");
        Advert advert = advertService.saveAdvert(new AdvertRequestDto(null, "Advert title", "Short advert description", "Long advert description",
                AdvertCategory.ADMINISTRATION, null), company.getId(), user.getId());
        InputStream inputStream = this.getClass().getResourceAsStream("/files/test1.pdf");
        MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);

        File file = fileService.saveFile(new FileDto(null, multipartFile, "Test file", "attachment/pdf", FileType.ATTACHMENT, advert.getId(), ResourceType.ADVERT));

        //when
        List<FileResponse> advertFiles = fileService.getFilesDataByResourceId(advert.getId(), ResourceType.ADVERT);
        fileService.deleteFile(file.getId(), null);
        List<FileResponse> advertFilesAfterDelete = fileService.getFilesDataByResourceId(advert.getId(), ResourceType.ADVERT);

        assertEquals(1, advertFiles.size());
        assertEquals(0, advertFilesAfterDelete.size());
    }

}

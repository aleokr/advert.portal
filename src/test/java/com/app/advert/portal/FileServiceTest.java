package com.app.advert.portal;

import com.app.advert.portal.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

@ActiveProfiles("test")
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/file-insert.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/clean.sql")
})
public class FileServiceTest {

    @Autowired
    FileService fileService;

    @Test
    public void saveFile() {

    }

    @Test
    public void updateFile() {

    }

    @Test
    public void deleteFile() {

    }

    @Test
    public void getFilesDataByResourceId() {

    }

}

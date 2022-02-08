package com.app.advert.portal;


import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.service.AdvertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/scripts/advert/advert-insert.sql"),
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/scripts/advert/advert-clear.sql")
//})
@ActiveProfiles("test")
@SpringBootTest
public class AdvertServiceTest {
    @Autowired
    AdvertService advertService;

    @Test
    public void testAdd() throws IOException {
        AdvertRequestDto advertRequestDto = new AdvertRequestDto(1L, "tytuł", "short", "long", AdvertCategory.ADMINISTRATION, null);
        advertService.saveAdvert(advertRequestDto);
        assertEquals(42, Integer.sum(19, 23));
    }

}

package com.app.advert.portal.elasticsearch.controller;

import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.elasticsearch.service.ElasticAdvertService;
import com.app.advert.portal.elasticsearch.service.ElasticFileService;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.service.impl.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/elastic")
@RequiredArgsConstructor
public class ElasticController {

    private final ElasticAdvertService advertService;
    private final ElasticFileService fileService;
    private final FileServiceImpl file;

    @PostMapping
    public void save(FileDto fileDto) throws IOException {
        fileService.saveFile(file.encodeFileToElasticFile(fileDto), AdvertType.INDIVIDUAL);
    }

    @GetMapping("/{id}")
    public void getFile(@PathVariable Long id){
        fileService.getFileById(id);
    }
}

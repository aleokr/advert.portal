package com.app.advert.portal.elasticsearch.controller;

import com.app.advert.portal.dto.AdvertListElasticResponse;
import com.app.advert.portal.elasticsearch.document.Advert;
import com.app.advert.portal.elasticsearch.service.ElasticAdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/elastic")
@RequiredArgsConstructor
public class ElasticController {

    private final ElasticAdvertService advertService;

    @PostMapping
    public void save(@RequestBody Advert advert){
        advertService.save(advert);
    }
}

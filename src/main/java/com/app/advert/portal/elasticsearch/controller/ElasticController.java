package com.app.advert.portal.elasticsearch.controller;

import com.app.advert.portal.elasticsearch.document.Advert;
import com.app.advert.portal.elasticsearch.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elastic")
@RequiredArgsConstructor
public class ElasticController {

    private final AdvertService advertService;

    @PostMapping
    public void save(@RequestBody Advert advert){
        advertService.save(advert);
    }


    @GetMapping("/{id}")
    public Advert get(@PathVariable String id){
        return advertService.findAdvertById(id);
    }
}

package com.app.advert.portal.elasticsearch.controller;

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


    @GetMapping("/{id}")
    public Advert get(@PathVariable String id){
        return advertService.findAdvertById(id);
    }

    @GetMapping("/advert")
    public List<Long> getAdvert() throws IOException {
        return advertService.getAdvertsWithText("some fruit", 1, 0);
    }
}

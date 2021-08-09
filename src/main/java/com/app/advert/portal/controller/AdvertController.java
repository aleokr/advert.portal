package com.app.advert.portal.controller;

import com.app.advert.portal.mapper.AdvertMapper;
import com.app.advert.portal.model.Advert;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adverts")
@CrossOrigin
@RequiredArgsConstructor
@Api(value = "Advert Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Advert"})
public class AdvertController {

    private final AdvertMapper advertMapper;

    @Operation(tags = {"Advert"}, description = "Return all adverts")
    @GetMapping("/getAll")
    public List<Advert> getAll() {
        return advertMapper.getAll();
    }
}

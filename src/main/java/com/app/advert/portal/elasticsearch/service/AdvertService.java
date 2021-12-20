package com.app.advert.portal.elasticsearch.service;

import com.app.advert.portal.elasticsearch.document.Advert;
import com.app.advert.portal.elasticsearch.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;

    public void save (Advert advert){
        advertRepository.save(advert);
    }

    public Advert findAdvertById(String id){
        return advertRepository.findById(id).orElse(null);
    }
}

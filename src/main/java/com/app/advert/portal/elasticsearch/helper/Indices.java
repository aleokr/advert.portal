package com.app.advert.portal.elasticsearch.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("indices")
public final class Indices {

    @Value("${elasticsearch.file.index}")
    public String FILES;

    @Value("${elasticsearch.advert.index}")
    public String ADVERTS;


    public String getFILES() {
        return FILES;
    }

    public String getADVERTS() {
        return ADVERTS;
    }
}

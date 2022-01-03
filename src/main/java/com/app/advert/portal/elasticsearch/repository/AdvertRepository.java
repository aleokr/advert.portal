package com.app.advert.portal.elasticsearch.repository;

import com.app.advert.portal.elasticsearch.document.Advert;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AdvertRepository extends ElasticsearchRepository<Advert, Integer> {
}

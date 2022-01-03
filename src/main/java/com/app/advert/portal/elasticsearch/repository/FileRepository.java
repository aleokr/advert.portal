package com.app.advert.portal.elasticsearch.repository;

import com.app.advert.portal.elasticsearch.document.File;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FileRepository extends ElasticsearchRepository<File, String> {
}

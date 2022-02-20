package com.app.advert.portal.elasticsearch.service;

import com.app.advert.portal.dto.AdvertListElasticResponse;
import com.app.advert.portal.elasticsearch.document.Advert;
import com.app.advert.portal.elasticsearch.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ElasticAdvertService {

    @Value("${elasticsearch.advert.index}")
    private String ADVERTS_INDEX;

    private final AdvertRepository advertRepository;

    private final RestHighLevelClient elasticClient;

    public void save(Advert advert) {
        advertRepository.save(advert);
    }

    public void delete(Advert advert) {
        advertRepository.delete(advert);
    }

    public Advert findAdvertById(Integer id) {
        return advertRepository.findById(id).orElse(null);
    }

    public AdvertListElasticResponse getAdvertsWithText(String text, String type, Integer limit, Integer offset) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //wyszukiwanie dla title i description dla zgodnego typu
        boolQueryBuilder
                .filter(QueryBuilders.multiMatchQuery(text, "title", "description"))
                .filter(QueryBuilders.multiMatchQuery(type, "type"));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.from(offset);
        searchSourceBuilder.size(limit);
        searchRequest.indices(ADVERTS_INDEX);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = elasticClient.search(searchRequest, RequestOptions.DEFAULT);

        Set<Long> advertIds = new HashSet<>();
        for (SearchHit hit : searchResponse.getHits()) {
            advertIds.add(Long.valueOf(hit.getId()));
        }

        AdvertListElasticResponse elasticResponse = new AdvertListElasticResponse();
        elasticResponse.setAdvertIds(advertIds);

        //ilość wszystkich
        TotalHits totalHits = searchResponse.getHits().getTotalHits();
        elasticResponse.setTotalCount(totalHits.value);

        return elasticResponse;
    }

}

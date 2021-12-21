package com.app.advert.portal.elasticsearch.service;

import com.app.advert.portal.elasticsearch.document.Advert;
import com.app.advert.portal.elasticsearch.helper.Indices;
import com.app.advert.portal.elasticsearch.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElasticAdvertService {

    private final AdvertRepository advertRepository;

    private final RestHighLevelClient elasticClient;

    public void save(Advert advert) {
        advertRepository.save(advert);
    }

    public Advert findAdvertById(String id) {
        return advertRepository.findById(id).orElse(null);
    }

    public List<Long> getAdvertsWithText(String text, Integer limit, Integer offset) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(text, "name", "description"));
        searchSourceBuilder.from(offset);
        searchSourceBuilder.size(limit);
        searchRequest.indices(Indices.ADVERTS_INDEX);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = elasticClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Long> advertIds = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits()) {
            advertIds.add(Long.valueOf(hit.getId()));
        }
        return advertIds;
    }

}

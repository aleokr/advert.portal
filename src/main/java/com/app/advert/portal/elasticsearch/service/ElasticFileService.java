package com.app.advert.portal.elasticsearch.service;

import com.app.advert.portal.dto.AdvertListElasticResponse;
import com.app.advert.portal.elasticsearch.document.File;
import com.app.advert.portal.elasticsearch.helper.Indices;
import com.app.advert.portal.elasticsearch.repository.FileRepository;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.enums.ResourceType;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.ingest.GetPipelineRequest;
import org.elasticsearch.action.ingest.PutPipelineRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.bytes.BytesArray;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ElasticFileService {

    private static final String ATTACHMENT_PIPELINE_NAME = "attachment";
    private final RestHighLevelClient elasticClient;
    private final FileRepository fileRepository;

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public AdvertListElasticResponse findSimilarFile(File file, AdvertType advertType, Integer offset, Integer limit) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        boolQueryBuilder
                .filter(QueryBuilders.multiMatchQuery(file.getAttachment().getContent(), "attachment.content"))
                .filter(QueryBuilders.multiMatchQuery(advertType.name(), "advertType"))
                .filter(QueryBuilders.multiMatchQuery(ResourceType.ADVERT.name(), "resourceType"));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.size(limit);
        searchSourceBuilder.from(offset);
        searchRequest.indices(Indices.FILES_INDEX);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = elasticClient.search(searchRequest, RequestOptions.DEFAULT);

        Set<Long> advertIds = new HashSet<>();
        for (SearchHit hit : searchResponse.getHits()) {
            advertIds.add(Long.valueOf(hit.getSourceAsMap().get("resourceId").toString()));
        }

        AdvertListElasticResponse elasticResponse = new AdvertListElasticResponse();
        elasticResponse.setAdvertIds(advertIds);

        //ilość wszystkich
        TotalHits totalHits = searchResponse.getHits().getTotalHits();
        elasticResponse.setTotalCount(totalHits.value);

        return elasticResponse;
    }

    public void saveFile(File file, AdvertType advertType) throws IOException {
        if(!isExistingPipeline(ATTACHMENT_PIPELINE_NAME)){
            putAttachmentPipeline();
        }
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index(Indices.FILES_INDEX);
        indexRequest.setPipeline(ATTACHMENT_PIPELINE_NAME);

        indexRequest.source(mapElasticFileToJson(file, advertType));
        indexRequest.id(file.getId().toString());
        elasticClient.index(indexRequest, RequestOptions.DEFAULT);
    }

    private Map<String, Object> mapElasticFileToJson(File file, AdvertType advertType) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("data", file.getData());
        jsonMap.put("id", file.getId());
        jsonMap.put("name", file.getName());
        jsonMap.put("resourceId", file.getResourceId());
        jsonMap.put("resourceType", file.getResourceType());
        jsonMap.put("advertType", advertType);
        return jsonMap;
    }

    private boolean isExistingPipeline(String pipelineName) throws IOException {
        try {
            return elasticClient.ingest().getPipeline(new GetPipelineRequest(pipelineName), RequestOptions.DEFAULT).isFound();
        } catch (ElasticsearchStatusException e) {
            if (e.status().getStatus() == 404) {
                return false;
            }
            throw new IOException(e);
        }
    }

    private void putAttachmentPipeline() throws IOException {
        String source =
                "{" +
                        "\"description\":\"Extract attachment information\"," +
                        "\"processors\": [" +
                                            "{" +
                                                "\"attachment\":" +
                                                                "{" +
                                                                    "\"field\":\"data\"" +
                                                                "}" +
                                            "}" +
                                        "]" +
                        "}";
        PutPipelineRequest request = new PutPipelineRequest(
                ATTACHMENT_PIPELINE_NAME,
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)),
                XContentType.JSON
        );
        elasticClient.ingest().putPipeline(request, RequestOptions.DEFAULT);
    }
}

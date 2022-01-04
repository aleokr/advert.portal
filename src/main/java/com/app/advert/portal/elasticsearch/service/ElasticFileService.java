package com.app.advert.portal.elasticsearch.service;

import com.app.advert.portal.elasticsearch.document.File;
import com.app.advert.portal.elasticsearch.helper.Indices;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.ingest.GetPipelineRequest;
import org.elasticsearch.action.ingest.PutPipelineRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.bytes.BytesArray;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElasticFileService {

    private static final String ATTACHMENT_PIPELINE_NAME = "attachment";
    private final RestHighLevelClient elasticClient;

    public void saveFile(File file) throws IOException {
        if(!isExistingPipeline(ATTACHMENT_PIPELINE_NAME)){
            putAttachmentPipeline();
        }
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index(Indices.FILES_INDEX);
        indexRequest.setPipeline(ATTACHMENT_PIPELINE_NAME);

        indexRequest.source(mapElasticFileToJson(file));
        elasticClient.index(indexRequest, RequestOptions.DEFAULT);
    }

    private Map<String, Object> mapElasticFileToJson(File file) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("data", file.getData());
        jsonMap.put("id", file.getId());
        jsonMap.put("name", file.getName());
        jsonMap.put("resourceId", file.getResourceId());
        jsonMap.put("resourceType", file.getResourceType());
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

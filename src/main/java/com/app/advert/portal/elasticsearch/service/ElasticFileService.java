package com.app.advert.portal.elasticsearch.service;

import com.app.advert.portal.elasticsearch.helper.Indices;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElasticFileService {

//    PUT _ingest/pipeline/attachment
//    {
//        "description" : "Extract attachment information",
//            "processors" : [
//        {
//            "attachment" : {
//            "field" : "data"
//        }
//        }
//  ]
//    }
//    PUT my_index/my_type/my_id?pipeline=attachment
//    {
//        "data": "e1xydGYxXGFuc2kNCkxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0DQpccGFyIH0="
//    }
//    GET my_index/my_type/my_id
//
//
//    {
//        "found": true,
//            "_index": "my_index",
//            "_type": "my_type",
//            "_id": "my_id",
//            "_version": 1,
//            "_source": {
//        "data": "e1xydGYxXGFuc2kNCkxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0DQpccGFyIH0=",
//                "attachment": {
//            "content_type": "application/rtf",
//                    "language": "ro",
//                    "content": "Lorem ipsum dolor sit amet",
//                    "content_length": 28
//        }
//    }
//    }
    private final RestHighLevelClient elasticClient;

    public void saveFile() throws IOException {
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index(Indices.FILES_INDEX);
        indexRequest.setPipeline("attachment");

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("data", "e1xydGYxXGFuc2kNCkxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0DQpccGFyIH0=");

        indexRequest.source(jsonMap);
        IndexResponse indexResponse = elasticClient.index(indexRequest, RequestOptions.DEFAULT);

        return;
    }

}

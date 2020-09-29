package com.enkeshu.es.controller;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("es")
@Slf4j
public class EsController {

    @Autowired
    RestHighLevelClient highLevelClient;


    @GetMapping("/createIndex")
    public Mono<ApiData> createIndex() {
        CreateIndexRequest indexRequest = new CreateIndexRequest("enkeshu");
        //indexRequest.settings(Settings.builder().put("index.number_of_shards", 1));
        indexRequest.alias(new Alias("idx0"));
        try {
            CreateIndexResponse createIndexResponse = highLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);
            return Mono.just(new ApiData<Boolean>(createIndexResponse.isAcknowledged()));
        } catch (IOException e) {
            log.error("", e);
        }
        return null;
    }

    @GetMapping("/{index}/getIndex")
    public Mono<ApiData> getIndex(@PathVariable(value = "index") String index) {
        GetIndexRequest indexRequest = new GetIndexRequest(index);
        try {
            GetIndexResponse getIndexResponse = highLevelClient.indices().get(indexRequest, RequestOptions.DEFAULT);
            return Mono.just(new ApiData<>(getIndexResponse.getSettings()));
        } catch (IOException e) {
            log.error("", e);
        }
        return null;
    }

    @GetMapping("/{index}/{type}/get/{id}")
    public Mono<ApiData> get(@PathVariable(value = "index") String index, @PathVariable(value = "type") String type, @PathVariable(value = "id") String id) {
        IndexRequest indexRequest=new IndexRequest(index);
        indexRequest.id(id);
        return null;
    }

}

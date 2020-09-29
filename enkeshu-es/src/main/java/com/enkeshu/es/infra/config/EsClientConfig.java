package com.enkeshu.es.infra.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class EsClientConfig {
    @Value("${spring.elasticsearch.rest.uris}")

    private String esUrl;

    @Bean
    public RestHighLevelClient highLevelClient() {
        final ClientConfiguration configuration = ClientConfiguration.builder().connectedTo(esUrl).build();
        return RestClients.create(configuration).rest();
    }
}

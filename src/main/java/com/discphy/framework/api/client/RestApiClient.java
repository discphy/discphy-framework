package com.discphy.framework.api.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY;

@Slf4j
@Component
public class RestApiClient {

    private final RestTemplate restTemplate;

    public RestApiClient(RestTemplateBuilder builder) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
        factory.setEncodingMode(VALUES_ONLY);

        this.restTemplate = builder.uriTemplateHandler(factory).build();
    }

    public <T> ResponseEntity<T> call(RequestEntity<?> entity, Class<T> responseType) throws RestClientException {
        return restTemplate.exchange(entity, responseType);
    }

    public <T> ResponseEntity<T> call(RequestEntity<?> entity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        return restTemplate.exchange(entity, responseType);
    }
}

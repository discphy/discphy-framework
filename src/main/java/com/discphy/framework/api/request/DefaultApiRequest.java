package com.discphy.framework.api.request;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.function.Consumer;

@Data
@Builder
@RequiredArgsConstructor
public class DefaultApiRequest<T> implements ApiRequest<T> {

    private final HttpMethod method;
    private final String url;
    private final HttpHeaders headers = new HttpHeaders();
    private final Object body;
    private final Class<T> responseType;
    private final Consumer<T> subscribe;
    private final Consumer<Throwable> error;
}

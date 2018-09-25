package com.framework;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;

@Filter("/demo/**")
public class TraceFilter implements HttpServerFilter {

    private final TraceService traceService;

    public TraceFilter(TraceService traceService) {
        this.traceService = traceService;
    }

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {

        System.out.println(request.getMethod().toString() + " uri: " + request.getUri() + " request body:" + request.getBody());

        return traceService.trace(request)
                .switchMap(aBoolean -> chain.proceed(request))
                .doOnNext(res ->
                        res.getHeaders().add("X-Trace-Enabled", "true")
                );
    }
}

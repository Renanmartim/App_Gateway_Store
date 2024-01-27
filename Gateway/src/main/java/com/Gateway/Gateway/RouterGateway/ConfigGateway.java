package com.Gateway.Gateway.RouterGateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGateway {

    @Value("${secret-pass}")
    private String SECRET_PASS;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("store", r -> r.path("/store")
                        .filters(f -> f
                                .addRequestHeader("Internal-ID", SECRET_PASS))
                        .uri("http://localhost:8082/"))
                .route("client", r -> r.path("/client")
                        .filters(f -> f
                                .addRequestHeader("Internal-ID", SECRET_PASS))
                        .uri("http://localhost:8081/"))
                .route("addbalance", r -> r.path("/client/addbalance")
                        .filters(f -> f
                                .addRequestHeader("Internal-ID", SECRET_PASS))
                        .uri("http://localhost:8081/"))
                .route("addProduct", r -> r.path("/store/addProduct")
                        .filters(f -> f
                                .addRequestHeader("Internal-ID", SECRET_PASS))
                        .uri("http://localhost:8082/"))
                .build();
    }
}

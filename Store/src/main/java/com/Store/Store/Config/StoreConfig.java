package com.Store.Store.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StoreConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

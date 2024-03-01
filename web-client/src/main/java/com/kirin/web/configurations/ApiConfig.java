package com.kirin.web.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApiConfig {

    /**
     * Создание Bean RestClient для общения с api-gateway
     * @return объект RestClient
     */
    @Bean
    public RestClient createRestClient() {
        return RestClient.create();
    }
}

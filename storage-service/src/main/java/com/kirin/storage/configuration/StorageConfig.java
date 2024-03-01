package com.kirin.storage.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    /**
     * Маппер сущностей. Например, из Entity в Response и обратно.
     */
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}

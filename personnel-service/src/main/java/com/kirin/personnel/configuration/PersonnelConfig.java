package com.kirin.personnel.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonnelConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}

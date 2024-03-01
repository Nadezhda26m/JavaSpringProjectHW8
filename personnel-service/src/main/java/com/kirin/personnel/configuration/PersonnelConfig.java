package com.kirin.personnel.configuration;

import com.kirin.personnel.repositories.EmployeeRepository;
import com.kirin.personnel.services.EmployeeCollectionService;
import com.kirin.personnel.services.EmployeeRepositoryService;
import com.kirin.personnel.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonnelConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    @ConditionalOnExpression("#{environment.getProperty('spring.cloud.config.profile').contains('prod')}")
    public EmployeeService employeeRepositoryService(EmployeeRepository employeeRepository) {
        return new EmployeeRepositoryService(employeeRepository);
    }

    @Bean
    @ConditionalOnExpression("#{environment.getProperty('spring.cloud.config.profile').contains('dev')}")
    public EmployeeService employeeCollectionService(EmployeeRepository employeeRepository) {
        return new EmployeeCollectionService(employeeRepository);
    }
}

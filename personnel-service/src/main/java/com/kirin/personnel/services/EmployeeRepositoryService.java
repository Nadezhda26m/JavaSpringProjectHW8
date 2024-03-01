package com.kirin.personnel.services;

import com.kirin.personnel.model.Employee;
import com.kirin.personnel.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod") // нет реализации БД
@RequiredArgsConstructor
public class EmployeeRepositoryService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

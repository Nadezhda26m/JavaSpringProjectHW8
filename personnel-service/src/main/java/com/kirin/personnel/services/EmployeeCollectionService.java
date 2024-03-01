package com.kirin.personnel.services;

import com.kirin.personnel.model.Employee;
import com.kirin.personnel.repositories.EmployeeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с данными о сотрудниках, хранящимися в коллекции
 */
@Service
@Profile("dev")
public class EmployeeCollectionService implements EmployeeService {

    private List<Employee> employees;

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Ленивое заполнение начальных данных для применения паттерна Bridge
     */
    private final EmployeeRepository employeeRepository;

    public EmployeeCollectionService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        init();
    }

    private void init() {
        employees = new ArrayList<>();
        employees.addAll(employeeRepository.findAll());
    }
}

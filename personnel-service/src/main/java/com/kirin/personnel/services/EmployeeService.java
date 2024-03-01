package com.kirin.personnel.services;

import com.kirin.personnel.model.Employee;

import java.util.List;

/**
 * Сервис для работы с данными сотрудников
 */
public interface EmployeeService {

    List<Employee> getAllEmployees();
}

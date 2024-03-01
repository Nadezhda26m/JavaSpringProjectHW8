package com.kirin.personnel.controllers;

import com.kirin.personnel.model.Employee;
import com.kirin.personnel.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для работы с персоналом
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/personnel")
public class PersonnelController {

    /**
     * Сервис для работы с данными о сотрудниках
     */
    private final EmployeeService employeeService;

    /**
     * Получение списка всех сотрудников.
     * @return список сотрудников
     */
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}

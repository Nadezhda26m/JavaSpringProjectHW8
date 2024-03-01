package com.kirin.personnel.controllers;

import com.kirin.personnel.model.Employee;
import com.kirin.personnel.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personnel")
public class PersonnelController {

    private final EmployeeService employeeService;

    @GetMapping("/new")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Welcome to personnel");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}

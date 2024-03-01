package com.kirin.personnel.repositories;

import com.kirin.personnel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью Employee (сотрудник)
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

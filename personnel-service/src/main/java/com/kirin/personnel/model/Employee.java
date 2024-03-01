package com.kirin.personnel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность сотрудника для работы с базой данных
 */
@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * Уникальный идентификатор сотрудника
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Имя сотрудника
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Отчество сотрудника
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Телефон для связи с сотрудником
     */
    @Column(name = "phone_number")
    private String phoneNumber; // TODO сделать список телефонов

    /**
     * Электронная почта для связи с сотрудником
     */
    private String email;

    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinTable(name = "employee_job",
    //         joinColumns = @JoinColumn(name = "employee_id"),
    //         inverseJoinColumns = @JoinColumn(name = "job_title_id"))
    // private Set<JobTitle> jobTitles = new HashSet<>();
}

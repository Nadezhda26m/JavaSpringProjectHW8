package com.kirin.personnel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Должность в организации
 */
@Setter
@Getter
@Entity
@Table(name = "job_titles")
public class JobTitle {

    /**
     * Уникальный идентификатор должности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Название должности
     */
    private String title;

    /**
     * Описание должности
     */
    private String description;

    /**
     * К какой группе должностей относится
     */
    @Enumerated(EnumType.STRING)
    private JobPosition position;

    // Job Requirements

    // @ManyToMany(mappedBy = "job_titles")
    // private Set<Employee> employees;
}

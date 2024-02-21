package com.kirin.personnel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Должность
 */
@Setter
@Getter
@Entity
@Table(name = "job_titles")
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private JobPosition position;

    // Job Requirements

    // @ManyToMany(mappedBy = "job_titles")
    // private Set<Employee> employees;
}

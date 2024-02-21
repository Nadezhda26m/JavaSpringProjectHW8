package com.kirin.storage.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "semi_finished_products")
public class SemiFinishedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * Количество в кг
     */
    private Double count;

    /**
     * Срок годности (часы)
     */
    @Column(name = "shelf_life")
    private Integer shelfLife;

    /**
     * Дата и время изготовления полуфабриката
     */
    @Column(name = "date_of_manufacture")
    private LocalDateTime dateOfManufacture;

    // storage conditions
}

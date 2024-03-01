package com.kirin.storage.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность полуфабриката для работы внутри приложения
 */
@Getter
@Setter
public class SemiFinishedProductResponse {

    /**
     * Уникальный идентификатор полуфабриката
     */
    private Long id;

    /**
     * Наименование полуфабриката
     */
    private String name;

    /**
     * Количество в кг
     */
    private Double count;

    /**
     * Срок годности (часы)
     */
    private Integer shelfLife;

    /**
     * Дата и время изготовления полуфабриката
     */
    private LocalDateTime dateOfManufacture;
}

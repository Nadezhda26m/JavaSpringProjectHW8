package com.kirin.web.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

/**
 * Запись для хранения данных о полуфабрикате
 * @param id уникальный идентификатор полуфабриката
 * @param name наименование полуфабриката
 * @param count количество в кг
 * @param shelfLife срок годности (часы)
 * @param dateOfManufacture дата и время изготовления полуфабриката
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SemiFinishedProduct(
        Long id,
        String name,
        Double count,
        Integer shelfLife,
        LocalDateTime dateOfManufacture) {
}

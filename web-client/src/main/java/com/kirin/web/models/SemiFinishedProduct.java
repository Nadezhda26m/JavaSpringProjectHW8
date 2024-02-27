package com.kirin.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SemiFinishedProduct(
        Long id,
        String name,
        Double count,
        Integer shelfLife,
        LocalDateTime dateOfManufacture) {
}

package com.kirin.web.models;

import java.time.LocalDateTime;

public record SemiFinishedProduct(
        Long id,
        String name,
        Double count,
        Integer shelfLife,
        LocalDateTime dateOfManufacture) {
}

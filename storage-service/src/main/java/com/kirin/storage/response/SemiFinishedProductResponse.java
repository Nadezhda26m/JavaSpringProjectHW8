package com.kirin.storage.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SemiFinishedProductResponse {

    private Long id;
    private String name;
    private Double count;
    private Integer shelfLife;
    private LocalDateTime dateOfManufacture;
}

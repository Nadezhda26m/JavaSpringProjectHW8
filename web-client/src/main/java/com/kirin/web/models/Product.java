package com.kirin.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Product(
        Long id,
        String name,
        String foodGroup,
        String consignment,
        Integer shelfLife,
        Double count,
        Boolean isPieceProduct,
        Boolean isInGoodCondition) {
}

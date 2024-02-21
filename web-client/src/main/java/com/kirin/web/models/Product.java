package com.kirin.web.models;

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

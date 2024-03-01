package com.kirin.web.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Запись для хранения данных о продукте
 * @param id уникальный идентификатор продукта
 * @param name название продукта
 * @param foodGroup название группы продуктов питания
 * @param consignment партия товара
 * @param shelfLife срок годности (дней)
 * @param count количество товара в кг
 * @param isPieceProduct является ли продукт штучным, иначе весовым
 * @param isInGoodCondition является ли продукт годным к употреблению (не испорчен)
 */
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

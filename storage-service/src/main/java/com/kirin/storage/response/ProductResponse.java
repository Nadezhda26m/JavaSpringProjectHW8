package com.kirin.storage.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность пищевого продукта для работы внутри приложения
 */
@Getter
@Setter
@EqualsAndHashCode
public class ProductResponse {

    /**
     * Уникальный идентификатор продукта
     */
    private Long id;

    /**
     * Название продукта
     */
    private String name;

    /**
     * Название группы продуктов питания
     */
    private String foodGroup;

    /**
     * Партия товара
     */
    private String consignment;

    /**
     * Срок годности (дней)
     */
    private Integer shelfLife;

    /**
     * Количество товара в кг
     */
    private Double count;

    /**
     * Является ли продукт штучным (заполняется кол-во и масса 1 шт.), иначе весовым (учет в кг)
     */
    private Boolean isPieceProduct;

    /**
     * Является ли продукт годным к употреблению (не испорчен)
     */
    private Boolean isInGoodCondition;

}

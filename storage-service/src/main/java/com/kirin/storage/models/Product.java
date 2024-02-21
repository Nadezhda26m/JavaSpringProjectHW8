package com.kirin.storage.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Пищевой продукт
 */
@Getter
@Setter
@Entity
@Table(name = "raw_products")
public class Product {

    /**
     * Уникальный идентификатор продукта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название продукта
     */
    @Column(nullable = false)
    private String name;

    /**
     * Название группы продуктов питания
     */
    @Column(name = "food_group")
    private String foodGroup;

    /**
     * Партия товара
     */
    private String consignment;

    /**
     * Срок годности (дней)
     */
    @Column(name = "shelf_life")
    private Integer shelfLife;

    /**
     * Количество товара в кг
     */
    private Double count;

    /**
     * Является ли продукт штучным (заполняется кол-во и масса 1 шт.), иначе весовым (учет в кг)
     */
    @Column(name = "is_piece_product")
    private Boolean isPieceProduct;

    /**
     * Является ли продукт годным к употреблению (не испорчен)
     */
    @Column(name = "is_in_good_condition")
    private Boolean isInGoodCondition;


}

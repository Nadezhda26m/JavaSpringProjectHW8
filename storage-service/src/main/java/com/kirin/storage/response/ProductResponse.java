package com.kirin.storage.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ProductResponse {

    private Long id;
    private String name;
    private String foodGroup;
    private String consignment;
    private Integer shelfLife;
    private Double count;
    private Boolean isPieceProduct;
    private Boolean isInGoodCondition;

}

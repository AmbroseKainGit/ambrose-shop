package com.ambrose.ambroseshop.request;

import java.math.BigDecimal;

import com.ambrose.ambroseshop.model.Category;

import lombok.Data;


@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private int inventory;

    private Category category;

}

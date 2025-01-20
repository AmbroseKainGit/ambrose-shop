package com.ambrose.ambroseshop.dto;

import java.math.BigDecimal;
import java.util.List;


import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private CategoryDto category;
    private List<ImageDto> images;
}

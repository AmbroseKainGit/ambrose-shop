package com.ambrose.ambroseshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambrose.ambroseshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryName(String category);

    List<Product> findByBrandName(String brand);

    List<Product> findByCategoryNameAndBrand(String category, String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);

}

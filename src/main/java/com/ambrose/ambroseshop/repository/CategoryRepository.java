package com.ambrose.ambroseshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambrose.ambroseshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}

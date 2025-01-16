package com.ambrose.ambroseshop.service.category;

import java.util.List;

import com.ambrose.ambroseshop.model.Category;

public interface ICategoryService {
    Category getCategoryById(Long categoryId);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category updateCategory(Category category, Long categoryId);
    void deleteCategory(Long categoryId);
}

package com.ambrose.ambroseshop.service.product;

import java.util.List;

import com.ambrose.ambroseshop.model.Product;
import com.ambrose.ambroseshop.request.AddProductRequest;
import com.ambrose.ambroseshop.request.ProductUpdateRequest;

public interface IProductService {

    Product createProduct(AddProductRequest product);
    Product getProductById(Long productId);
    void deleteProduct(Long productId);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String name, String brand);
    Long countProductsByBrandAndNam3e(String brand, String name);
}

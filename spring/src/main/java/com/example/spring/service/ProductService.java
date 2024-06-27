package com.example.spring.service;

import com.example.spring.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    Product update(Long id, Product product);

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);

    List<Product> findAllByNameContaining(String keyword);
}

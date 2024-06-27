package com.example.spring.service;

import com.example.spring.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    Category update(Long id, Category category);

    void delete(Long id);
}

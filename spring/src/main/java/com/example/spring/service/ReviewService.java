package com.example.spring.service;

import com.example.spring.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();
    Review findById(Long id);
    Review save(Review review);

    Review update(Long id, Review review);

    void delete(Long id);
    List<Review> findAllByProductId(Long productId);
}

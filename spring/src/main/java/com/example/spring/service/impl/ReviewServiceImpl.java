package com.example.spring.service.impl;

import com.example.spring.domain.Address;
import com.example.spring.domain.Review;
import com.example.spring.repository.ReviewRepository;
import com.example.spring.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Review not found"));
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);

        if(reviewOptional.isPresent()) {
            Review newReview = reviewOptional.get();
            newReview.setComment(review.getComment());
            return reviewRepository.save(newReview);
        }
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> findAllByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId);
    }
}

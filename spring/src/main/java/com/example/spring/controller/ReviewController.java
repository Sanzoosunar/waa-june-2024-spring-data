package com.example.spring.controller;

import com.example.spring.domain.Review;
import com.example.spring.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        if(review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.save(review);
        return ResponseEntity.ok(savedReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable Long id) {
        reviewService.update(id, review);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Long productId) {
        List<Review> review = reviewService.findAllByProductId(productId);
        if(review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }
}
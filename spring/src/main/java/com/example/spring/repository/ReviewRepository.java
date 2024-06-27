package com.example.spring.repository;

import com.example.spring.domain.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review,Long> {
    List<Review> findAllByProductId(Long productId);
}

package com.example.spring.repository;


import com.example.spring.domain.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends ListCrudRepository<Category,Long> {

}
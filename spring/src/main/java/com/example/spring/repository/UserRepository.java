package com.example.spring.repository;

import com.example.spring.domain.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User,Long> {

}
package com.example.spring.repository;

import com.example.spring.domain.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ListCrudRepository<Address,Long> {

}

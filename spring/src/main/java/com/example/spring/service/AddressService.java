package com.example.spring.service;

import com.example.spring.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address findById(Long id);
    Address save(Address address);

    Address update(Long id, Address address);

    void delete(Long id);

}

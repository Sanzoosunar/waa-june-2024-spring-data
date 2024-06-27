package com.example.spring.service.impl;

import com.example.spring.domain.Address;
import com.example.spring.repository.AddressRepository;
import com.example.spring.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) throws NoSuchElementException{
        return addressRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Address not found"));
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Optional<Address> optional = addressRepository.findById(id);
        if(optional.isPresent()) {
            Address newAddress = optional.get();
            newAddress.setCity(address.getCity());
            newAddress.setStreet(address.getStreet());
            newAddress.setZip(address.getZip());
            return addressRepository.save(newAddress);
        }
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}

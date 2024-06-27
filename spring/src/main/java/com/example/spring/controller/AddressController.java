package com.example.spring.controller;
import com.example.spring.domain.Address;
import com.example.spring.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address savedAddress = addressService.save(address);
        return ResponseEntity.ok(savedAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable Long id) {
        addressService.update(id, address);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> address = addressService.findAll();
        if(address != null) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddressById(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
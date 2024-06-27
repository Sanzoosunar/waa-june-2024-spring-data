package com.example.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
}

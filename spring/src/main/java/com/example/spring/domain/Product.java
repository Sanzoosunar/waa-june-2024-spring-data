package com.example.spring.domain;

import lombok.*;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String name;
    private Double price;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category prcategory;

//    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private List<Review> reviews = new ArrayList<>();
}

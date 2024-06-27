package com.example.spring.service.impl;

import com.example.spring.domain.Product;
import com.example.spring.repository.ProductRepository;
import com.example.spring.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            Product newProduct = productOptional.get();
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            newProduct.setCategory(product.getCategory());
            productRepository.save(newProduct);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(Double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice) {
        return productRepository.findAllByCategoryNameAndPriceLessThan(categoryName, maxPrice);
    }

    @Override
    public List<Product> findAllByNameContaining(String keyword) {
        return productRepository.findAllByNameContaining(keyword);
    }
}

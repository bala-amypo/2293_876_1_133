package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product createProduct(Product product) {
        product.setActive(true);
        return repository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public void deactivateProduct(Long id) {
        Product product = repository.findById(id).orElseThrow();
        product.setActive(false);
        repository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}

package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product product) { return repo.save(product); }
    public Product getProductById(Long id) { return repo.findById(id).orElse(null); }
    public List<Product> getProducts() { return repo.findAll(); }
}

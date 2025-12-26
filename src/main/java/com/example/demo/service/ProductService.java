package com.example.demo.service;

import com.example.demo.entity.Product;

public interface ProductService {
    void deactivateProduct(Long id);
    Product getProductById(Long id);
}

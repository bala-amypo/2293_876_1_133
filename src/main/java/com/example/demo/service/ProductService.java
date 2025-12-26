package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product);   // 👈 ADD
    List<Product> getProducts();               // 👈 ADD

    void deactivateProduct(Long id);
    Product getProductById(Long id);
}

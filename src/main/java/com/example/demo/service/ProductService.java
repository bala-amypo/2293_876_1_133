package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Product;

public interface ProductService {

    Product save(Product product);

    List<Product> getAllProducts();   // ⚠ method name must match

    Product getById(Long id);

    void delete(Long id);
}

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @GetMapping
    public List<Product> list() {
        return service.getAllProducts();
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sku;

    private String name;
    private String category;
    private boolean active = true;

    public Product() {}

    public Product(String sku, String name, String category) {
        this.sku = sku;
        this.name = name;
        this.category = category;
    }

    public Long getId() { return id; }
    public String getSku() { return sku; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setSku(String sku) { this.sku = sku; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setActive(boolean active) { this.active = active; }
}

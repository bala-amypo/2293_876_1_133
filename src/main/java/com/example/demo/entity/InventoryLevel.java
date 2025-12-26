package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"store_id","product_id"})
)
public class InventoryLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer quantity;
    private LocalDateTime lastUpdated;

    public InventoryLevel() {}

    public InventoryLevel(Store store, Product product, Integer quantity) {
        this.store = store;
        this.product = product;
        this.quantity = quantity;
    }

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        lastUpdated = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Store getStore() { return store; }
    public Product getProduct() { return product; }
    public Integer getQuantity() { return quantity; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }

    public void setId(Long id) { this.id = id; }
    public void setStore(Store store) { this.store = store; }
    public void setProduct(Product product) { this.product = product; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}

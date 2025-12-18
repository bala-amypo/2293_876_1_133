package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TransferSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_store_id")
    private Store sourceStore;

    @ManyToOne
    @JoinColumn(name = "target_store_id")
    private Store targetStore;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private String priority; // HIGH / MEDIUM / LOW

    private String status = "PENDING";

    private LocalDateTime suggestedAt = LocalDateTime.now();

    // Constructors
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Store getSourceStore() { return sourceStore; }
    public void setSourceStore(Store sourceStore) {
        this.sourceStore = sourceStore;
    }

    public Store getTargetStore() { return targetStore; }
    public void setTargetStore(Store targetStore) {
        this.targetStore = targetStore;
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPriority() { return priority; }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSuggestedAt() { 
        return suggestedAt; 
    }
    public void setSuggestedAt(LocalDateTime suggestedAt) {
        this.suggestedAt = suggestedAt;
    }


    public TransferSuggestion(Store sourceStore, Store targetStore,
                              Product product, Integer quantity, String priority) {
        this.sourceStore = sourceStore;
        this.targetStore = targetStore;
        this.product = product;
        this.quantity = quantity;
        this.priority = priority;
    
    
    public TransferSuggestion() {


    }
}

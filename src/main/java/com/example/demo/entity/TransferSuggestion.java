package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TransferSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Store sourceStore;

    @ManyToOne
    private Store targetStore;

    private Integer suggestedQuantity;
    private String reason;
    private LocalDateTime generatedAt;

    public TransferSuggestion() {}

    public TransferSuggestion(Product product, Store sourceStore, Store targetStore,
                              Integer suggestedQuantity, String reason) {
        this.product = product;
        this.sourceStore = sourceStore;
        this.targetStore = targetStore;
        this.suggestedQuantity = suggestedQuantity;
        this.reason = reason;
    }

    @PrePersist
    public void onCreate() {
        generatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Product getProduct() { return product; }
    public Store getSourceStore() { return sourceStore; }
    public Store getTargetStore() { return targetStore; }
    public Integer getSuggestedQuantity() { return suggestedQuantity; }
    public String getReason() { return reason; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setProduct(Product product) { this.product = product; }
    public void setSourceStore(Store sourceStore) { this.sourceStore = sourceStore; }
    public void setTargetStore(Store targetStore) { this.targetStore = targetStore; }
    public void setSuggestedQuantity(Integer suggestedQuantity) { this.suggestedQuantity = suggestedQuantity; }
    public void setReason(String reason) { this.reason = reason; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}

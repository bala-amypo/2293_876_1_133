// package com.example.inventory.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class InventoryLevel {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "store_id", nullable = false)
//     private Store store;

//     @ManyToOne
//     @JoinColumn(name = "product_id", nullable = false)
//     private Product product;

//     @Column(nullable = false)
//     private Integer quantity;

//     private LocalDateTime lastUpdated;

   

//     public Long getId() { 
//         return id; 
//     }
//     public void setId(Long id) { 
//         this.id = id; 
//     }

//     public Store getStore() { 
//         return store; 
//     }
//     public void setStore(Store store) { 
//         this.store = store; 
//     }

//     public Product getProduct() { 
//         return product; 
//     }
//     public void setProduct(Product product) { 
//         this.product = product; 
//     }

//     public Integer getQuantity() { 
//         return quantity; 
//     }
//     public void setQuantity(Integer quantity) { 
//         this.quantity = quantity; 
//     }

//     public LocalDateTime getLastUpdated() { 
//         return lastUpdated; 
//     }
//     public void setLastUpdated(LocalDateTime lastUpdated) {
//         this.lastUpdated = lastUpdated;
//     }


    

//     public InventoryLevel(Store store, Product product, Integer quantity) {
//         this.store = store;
//         this.product = product;
//         this.quantity = quantity;
//     }

//     @PrePersist
//     @PreUpdate
//     public void updateTimestamp() {
//         this.lastUpdated = LocalDateTime.now();
//     }


//     public InventoryLevel() {
    
//     }
// }

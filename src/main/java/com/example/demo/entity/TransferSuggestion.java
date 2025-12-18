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

    @Column(nullable = false)
    private String priority; // HIGH / MEDIUM / LOW

    @Column(nullable = false)
    private String status = "PENDING";

    private LocalDateTime suggestedAt = LocalDateTime.now();


}

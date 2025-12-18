package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stores", uniqueConstraints = {
        @UniqueConstraint(columnNames = "store_name")
})
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_name", nullable = false, unique = true)
    private String storeName;

    private String address;
    private String region;

    @Column(nullable = false)
    private Boolean active = true;

}

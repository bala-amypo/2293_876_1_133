package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DemandForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer forecastedDemand;
    private LocalDate forecastDate;

    public DemandForecast() {}

    public DemandForecast(Store store, Product product, Integer forecastedDemand, LocalDate forecastDate) {
        this.store = store;
        this.product = product;
        this.forecastedDemand = forecastedDemand;
        this.forecastDate = forecastDate;
    }

    public Long getId() { return id; }
    public Store getStore() { return store; }
    public Product getProduct() { return product; }
    public Integer getForecastedDemand() { return forecastedDemand; }
    public LocalDate getForecastDate() { return forecastDate; }

    public void setId(Long id) { this.id = id; }
    public void setStore(Store store) { this.store = store; }
    public void setProduct(Product product) { this.product = product; }
    public void setForecastedDemand(Integer forecastedDemand) { this.forecastedDemand = forecastedDemand; }
    public void setForecastDate(LocalDate forecastDate) { this.forecastDate = forecastDate; }
}

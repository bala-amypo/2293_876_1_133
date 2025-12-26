package com.example.demo.dto;

public class InventoryRequestDto {

    private Long storeId;
    private Long productId;
    private Integer quantity;

    public InventoryRequestDto() {}

    public InventoryRequestDto(Long storeId, Long productId, Integer quantity) {
        this.storeId = storeId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

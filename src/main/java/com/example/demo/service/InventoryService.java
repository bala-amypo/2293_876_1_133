package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;

import java.util.List;

public interface InventoryService {
    InventoryLevel saveInventory(InventoryLevel inventory);
    List<InventoryLevel> getByStore(Long storeId);
}

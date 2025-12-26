package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import java.util.List;

public interface InventoryLevelService {

    InventoryLevel createOrUpdateInventory(InventoryLevel inventory);  // 👈 ADD
    List<InventoryLevel> getInventoryForProduct(Long productId);        // 👈 ADD

    List<InventoryLevel> getInventoryForStore(Long storeId);
}

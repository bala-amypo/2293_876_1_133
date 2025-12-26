package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import java.util.List;

public interface InventoryLevelService {
    InventoryLevel saveInventory(InventoryLevel inventory);
    List<InventoryLevel> findByStoreId(Long storeId);
    List<InventoryLevel> findByProductId(Long productId);
}

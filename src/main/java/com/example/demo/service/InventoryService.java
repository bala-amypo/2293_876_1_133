package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.InventoryLevel;

public interface InventoryService {

    InventoryLevel updateInventory(InventoryLevel inventory);

    List<InventoryLevel> getInventoryByStore(Long storeId);

    List<InventoryLevel> getInventoryByProduct(Long productId);
}

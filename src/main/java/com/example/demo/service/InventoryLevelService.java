package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import java.util.List;

public interface InventoryLevelService {

    InventoryLevel save(InventoryLevel inventoryLevel);

    InventoryLevel getById(Long id);

    List<InventoryLevel> getAll();

    List<InventoryLevel> getByStoreId(Long storeId);

    List<InventoryLevel> getByProductId(Long productId);

    InventoryLevel update(Long id, InventoryLevel inventoryLevel);

    void delete(Long id);
}

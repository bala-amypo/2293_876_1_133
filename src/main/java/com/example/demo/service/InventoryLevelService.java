package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.InventoryLevel;

public interface InventoryLevelService {

    InventoryLevel save(InventoryLevel inventory);

    InventoryLevel update(Long id, InventoryLevel inventory);

    InventoryLevel getById(Long id);

    List<InventoryLevel> getAll();

    List<InventoryLevel> getByStoreId(Long storeId);

    List<InventoryLevel> getByProductId(Long productId);

    void delete(Long id);
}

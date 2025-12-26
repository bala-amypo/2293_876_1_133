package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.InventoryLevel;

public interface InventoryLevelService {
    List<InventoryLevel> getInventoryForStore(Long storeId);
}

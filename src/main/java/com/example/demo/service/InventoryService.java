package com.example.demo.service;

import com.example.demo.entity.Inventory;
import java.util.List;

public interface InventoryService {

    Inventory addInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Inventory getInventoryById(Long id);
}

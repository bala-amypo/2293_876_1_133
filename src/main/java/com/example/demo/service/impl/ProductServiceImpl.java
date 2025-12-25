package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryLevelRepository repository;

    public InventoryServiceImpl(InventoryLevelRepository repository) {
        this.repository = repository;
    }

    @Override
    public InventoryLevel updateInventory(InventoryLevel inventory) {
        return repository.save(inventory);
    }

    @Override
    public List<InventoryLevel> getInventoryByStore(Long storeId) {
        return repository.findByStore_Id(storeId);
    }

    @Override
    public List<InventoryLevel> getInventoryByProduct(Long productId) {
        return repository.findByProduct_Id(productId);
    }
}

package com.example.demo.service.impl;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryLevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryLevelServiceImpl implements InventoryLevelService {

    private final InventoryLevelRepository repo;

    public InventoryLevelServiceImpl(InventoryLevelRepository repo) {
        this.repo = repo;
    }

    public InventoryLevel saveInventory(InventoryLevel inventory) {
        return repo.save(inventory);
    }

    public List<InventoryLevel> findByStoreId(Long storeId) {
        return repo.findAll();
    }

    public List<InventoryLevel> findByProductId(Long productId) {
        return repo.findAll();
    }
}

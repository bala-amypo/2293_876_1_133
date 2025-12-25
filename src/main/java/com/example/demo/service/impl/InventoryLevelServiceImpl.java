package com.example.demo.service.impl;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.exception.BadRequestException;
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

    @Override
    public InventoryLevel createOrUpdateInventory(InventoryLevel inv) {
        if (inv.getQuantity() < 0)
            throw new BadRequestException("Inventory cannot be negative");
        return repo.save(inv);
    }

    @Override
    public List<InventoryLevel> getInventoryForStore(Long storeId) {
        return repo.findByStore_Id(storeId);
    }

    @Override
    public List<InventoryLevel> getInventoryForProduct(Long productId) {
        return repo.findByProduct_Id(productId);
    }
}

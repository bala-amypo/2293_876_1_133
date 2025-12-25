package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryLevelService;

@Service
public class InventoryLevelServiceImpl implements InventoryLevelService {

    private final InventoryLevelRepository inventoryLevelRepository;

    public InventoryLevelServiceImpl(InventoryLevelRepository inventoryLevelRepository) {
        this.inventoryLevelRepository = inventoryLevelRepository;
    }

    @Override
    public InventoryLevel save(InventoryLevel inventory) {
        return inventoryLevelRepository.save(inventory);
    }

    @Override
    public InventoryLevel update(Long id, InventoryLevel inventory) {
        InventoryLevel existing =
                inventoryLevelRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Inventory not found"));

        existing.setQuantity(inventory.getQuantity());
        existing.setStore(inventory.getStore());
        existing.setProduct(inventory.getProduct());

        return inventoryLevelRepository.save(existing);
    }

    @Override
    public InventoryLevel getById(Long id) {
        return inventoryLevelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Override
    public List<InventoryLevel> getAll() {
        return inventoryLevelRepository.findAll();
    }

    @Override
    public List<InventoryLevel> getByStoreId(Long storeId) {
        return inventoryLevelRepository.findByStore_Id(storeId);
    }

    @Override
    public List<InventoryLevel> getByProductId(Long productId) {
        return inventoryLevelRepository.findByProduct_Id(productId);
    }

    @Override
    public void delete(Long id) {
        inventoryLevelRepository.deleteById(id);
    }
}

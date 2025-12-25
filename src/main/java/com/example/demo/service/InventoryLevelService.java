package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.InventoryLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryLevelService {
    @Autowired
    private InventoryLevelRepository inventoryLevelRepository;

    public InventoryLevel createOrUpdateInventory(InventoryLevel inventory) {
        if (inventory.getQuantity() < 0) {
            throw new BadRequestException("Quantity cannot be negative");
        }
        
        Optional<InventoryLevel> existing = inventoryLevelRepository
                .findByStore_IdAndProduct_Id(inventory.getStore().getId(), inventory.getProduct().getId());
        
        if (existing.isPresent()) {
            InventoryLevel existingInv = existing.get();
            existingInv.setQuantity(inventory.getQuantity());
            return inventoryLevelRepository.save(existingInv);
        }
        
        return inventoryLevelRepository.save(inventory);
    }

    public List<InventoryLevel> getInventoryForStore(Long storeId) {
        return inventoryLevelRepository.findByStore_Id(storeId);
    }

    public List<InventoryLevel> getInventoryForProduct(Long productId) {
        return inventoryLevelRepository.findByProduct_Id(productId);
    }
}
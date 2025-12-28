package com.example.demo.service.impl;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.InventoryService;
import org.springframework.stereotype.Service;
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory createOrUpdateInventory(Inventory inventory) {

        Inventory entity;

        // ✅ FIX: Only call findById if ID is NOT null
        if (inventory.getId() != null) {
            entity = inventoryRepository
                    .findById(inventory.getId())
                    .orElse(new Inventory());
        } else {
            entity = new Inventory();
        }

        entity.setProduct(inventory.getProduct());
        entity.setStore(inventory.getStore());
        entity.setQuantity(inventory.getQuantity());

        return inventoryRepository.save(entity);
    }
}

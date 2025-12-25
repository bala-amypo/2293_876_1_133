package com.example.demo.service.impl;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryLevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryLevelServiceImpl implements InventoryLevelService {

    private final InventoryLevelRepository repository;

    public InventoryLevelServiceImpl(InventoryLevelRepository repository) {
        this.repository = repository;
    }

    @Override
    public InventoryLevel save(InventoryLevel inventoryLevel) {
        if (inventoryLevel.getQuantity() < 0) {
            throw new BadRequestException("Inventory quantity cannot be negative");
        }
        return repository.save(inventoryLevel);
    }

    @Override
    public InventoryLevel getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Inventory not found with id " + id));
    }

    @Override
    public List<InventoryLevel> getAll() {
        return repository.findAll();
    }

    @Override
    public List<InventoryLevel> getByStoreId(Long storeId) {
        return repository.findByStore_Id(storeId);
    }

    @Override
    public List<InventoryLevel> getByProductId(Long productId) {
        return repository.findByProduct_Id(productId);
    }

    @Override
    public InventoryLevel update(Long id, InventoryLevel inventoryLevel) {

        InventoryLevel existing = getById(id);

        if (inventoryLevel.getQuantity() < 0) {
            throw new BadRequestException("Inventory quantity cannot be negative");
        }

        existing.setStore(inventoryLevel.getStore());
        existing.setProduct(inventoryLevel.getProduct());
        existing.setQuantity(inventoryLevel.getQuantity());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        InventoryLevel existing = getById(id);
        repository.delete(existing);
    }
}

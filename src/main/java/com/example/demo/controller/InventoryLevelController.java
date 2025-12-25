package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryLevelController {

    private final InventoryLevelService inventoryLevelService;

    public InventoryLevelController(InventoryLevelService inventoryLevelService) {
        this.inventoryLevelService = inventoryLevelService;
    }

    @PostMapping
    public InventoryLevel create(@RequestBody InventoryLevel inventory) {
        return inventoryLevelService.save(inventory);
    }

    @GetMapping("/{id}")
    public InventoryLevel getById(@PathVariable Long id) {
        return inventoryLevelService.getById(id);
    }

    @GetMapping
    public List<InventoryLevel> getAll() {
        return inventoryLevelService.getAll();
    }

    @GetMapping("/store/{storeId}")
    public List<InventoryLevel> getByStore(@PathVariable Long storeId) {
        return inventoryLevelService.getByStoreId(storeId);
    }

    @GetMapping("/product/{productId}")
    public List<InventoryLevel> getByProduct(@PathVariable Long productId) {
        return inventoryLevelService.getByProductId(productId);
    }

    @PutMapping("/{id}")
    public InventoryLevel update(@PathVariable Long id,
                                 @RequestBody InventoryLevel inventory) {
        return inventoryLevelService.update(id, inventory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventoryLevelService.delete(id);
    }
}

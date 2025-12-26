package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryLevelController {

    private final InventoryLevelService service;

    public InventoryLevelController(
            InventoryLevelService service) {
        this.service = service;
    }

    @PostMapping
    public InventoryLevel save(
            @RequestBody InventoryLevel inventory) {
        return service.saveInventory(inventory);
    }

    @GetMapping("/store/{storeId}")
    public List<InventoryLevel> byStore(
            @PathVariable Long storeId) {
        return service.getByStore(storeId);
    }

    @GetMapping("/product/{productId}")
    public List<InventoryLevel> byProduct(
            @PathVariable Long productId) {
        return service.getByProduct(productId);
    }
}

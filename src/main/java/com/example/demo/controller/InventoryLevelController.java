package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public InventoryLevel update(@RequestBody InventoryLevel inventory) {
        return service.updateInventory(inventory);
    }

    @GetMapping("/store/{storeId}")
    public List<InventoryLevel> byStore(@PathVariable Long storeId) {
        return service.getInventoryByStore(storeId);
    }

    @GetMapping("/product/{productId}")
    public List<InventoryLevel> byProduct(@PathVariable Long productId) {
        return service.getInventoryByProduct(productId);
    }
}

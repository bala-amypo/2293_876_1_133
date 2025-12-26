package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryLevelController {

    private final InventoryLevelService service;

    public InventoryLevelController(InventoryLevelService service) {
        this.service = service;
    }

    @PostMapping
    public InventoryLevel createOrUpdate(@RequestBody InventoryLevel inventory) {
        return service.createOrUpdateInventory(inventory);
    }

    @GetMapping("/product/{productId}")
    public List<InventoryLevel> getByProduct(@PathVariable Long productId) {
        return service.getInventoryForProduct(productId);
    }
}

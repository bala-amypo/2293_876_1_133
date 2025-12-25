package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryLevelService inventoryLevelService;

    @PostMapping
    public ResponseEntity<InventoryLevel> createOrUpdateInventory(@RequestBody InventoryLevel inventory) {
        return ResponseEntity.ok(inventoryLevelService.createOrUpdateInventory(inventory));
    }
}
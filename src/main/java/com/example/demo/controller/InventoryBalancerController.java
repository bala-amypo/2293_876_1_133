package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.InventoryBalancerService;

@RestController
@RequestMapping("/api/inventory/balance")
public class InventoryBalancerController {

    private final InventoryBalancerService service;

    public InventoryBalancerController(InventoryBalancerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> balanceInventory() {
        service.balanceInventory();
        return ResponseEntity.ok("Inventory balanced successfully");
    }
}

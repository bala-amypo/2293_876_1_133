package com.example.demo.controller;

import com.example.demo.service.InventoryBalancerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryBalancerController {

    private final InventoryBalancerService service;

    public InventoryBalancerController(InventoryBalancerService service) {
        this.service = service;
    }

    @GetMapping("/inventory/balance")
    public List<String> balanceInventory() {
        return service.balanceInventory();
    }

    @GetMapping("/inventory/suggestions")
    public List<String> getSuggestions(Long productId) {
        return service.generateSuggestions(productId);
    }
}

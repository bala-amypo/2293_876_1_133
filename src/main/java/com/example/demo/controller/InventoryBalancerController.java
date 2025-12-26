package com.example.demo.controller;

import com.example.demo.service.InventoryBalancerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory/balance")
public class InventoryBalancerController {

    private final InventoryBalancerService service;

    public InventoryBalancerController(InventoryBalancerService service) {
        this.service = service;
    }

    @PostMapping
    public void balanceInventory() {
        service.balanceInventory();
    }
}

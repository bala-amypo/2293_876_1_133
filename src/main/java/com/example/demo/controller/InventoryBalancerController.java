package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory/balance")
public class InventoryBalancerController {

    private final InventoryBalancerService service;

    public InventoryBalancerController(
            InventoryBalancerService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransferSuggestion> balanceInventory() {
        return service.balanceInventory();
    }
}

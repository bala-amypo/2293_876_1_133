package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balance")
public class InventoryBalancerController {

    private final InventoryBalancerService balancerService;

    public InventoryBalancerController(
            InventoryBalancerService balancerService) {
        this.balancerService = balancerService;
    }

    @PostMapping("/{productId}")
    public List<TransferSuggestion> generate(
            @PathVariable Long productId) {

        return balancerService.generateSuggestions(productId);
    }

    @GetMapping("/store/{storeId}")
    public List<TransferSuggestion> byStore(
            @PathVariable Long storeId) {

        return balancerService.getSuggestionsForStore(storeId);
    }

    @GetMapping("/{id}")
    public TransferSuggestion byId(@PathVariable Long id) {
        return balancerService.getSuggestionById(id);
    }
}

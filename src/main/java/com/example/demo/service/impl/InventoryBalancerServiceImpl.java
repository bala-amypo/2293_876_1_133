package com.example.demo.service.impl;

import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    @Override
    public List<String> balanceInventory() {
        List<String> actions = new ArrayList<>();
        actions.add("Inventory balanced successfully");
        return actions;
    }

    @Override
    public List<String> generateSuggestions(Long productId) {
        List<String> suggestions = new ArrayList<>();
        suggestions.add("Move stock from Store A to Store B");
        return suggestions;
    }
}

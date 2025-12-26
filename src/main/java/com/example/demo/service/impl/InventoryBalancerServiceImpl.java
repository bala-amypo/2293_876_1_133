package com.example.demo.service.impl;

import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    @Override
    public String balanceInventory() {
        return "Inventory balanced successfully";
    }

    @Override
    public String getSuggestionById(Long id) {
        return "Suggestion for inventory id " + id;
    }
}

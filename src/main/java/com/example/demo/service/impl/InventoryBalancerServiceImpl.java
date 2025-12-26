package com.example.demo.service.impl;

import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    @Override
    public void balanceInventory() {
        // simple placeholder logic
        System.out.println("Balancing inventory across stores...");
    }

    @Override
    public List<String> generateSuggestions(Long storeId) {
        return List.of("Move excess stock", "Reorder low inventory");
    }

    @Override
    public String getSuggestionsById(Long id) {
        return "Sample suggestion";
    }
}

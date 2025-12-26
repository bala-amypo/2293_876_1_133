package com.example.demo.service;

import java.util.List;

public interface InventoryBalancerService {

    void balanceInventory();

    List<String> generateSuggestions(Long productId);
}

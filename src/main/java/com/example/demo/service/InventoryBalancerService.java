package com.example.demo.service;

import java.util.List;

public interface InventoryBalancerService {

    List<String> balanceInventory(); // return list of actions

    List<String> generateSuggestions(Long productId);

}

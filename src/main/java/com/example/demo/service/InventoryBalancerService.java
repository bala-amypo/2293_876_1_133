package com.example.demo.service;

import java.util.List;

public interface InventoryBalancerService {
    List<String> generateSuggestions(Long storeId);
    String getSuggestionsById(Long id);
}

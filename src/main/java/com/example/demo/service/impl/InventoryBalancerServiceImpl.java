package com.example.demo.service.impl;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final InventoryLevelRepository inventoryRepo;
    private final TransferSuggestionRepository transferRepo;

    public InventoryBalancerServiceImpl(
            InventoryLevelRepository inventoryRepo,
            TransferSuggestionRepository transferRepo) {
        this.inventoryRepo = inventoryRepo;
        this.transferRepo = transferRepo;
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        List<InventoryLevel> levels = inventoryRepo.findByProductId(productId);
        List<TransferSuggestion> suggestions = new ArrayList<>();

        if (levels.size() < 2) return suggestions;

        InventoryLevel from = levels.get(0);
        InventoryLevel to = levels.get(1);

        TransferSuggestion suggestion = new TransferSuggestion();
        suggestion.setProductId(productId);
        suggestion.setFromStoreId(from.getStoreId());
        suggestion.setToStoreId(to.getStoreId());
        suggestion.setQuantity(10);

        suggestions.add(transferRepo.save(suggestion));
        return suggestions;
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return transferRepo.findById(id).orElse(null);
    }
}

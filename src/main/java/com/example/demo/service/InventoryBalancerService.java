package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private InventoryLevelRepository inventoryLevelRepository;
    
    @Autowired
    private DemandForecastRepository demandForecastRepository;
    
    @Autowired
    private TransferSuggestionRepository transferSuggestionRepository;

    public List<TransferSuggestion> generateSuggestions(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        
        if (!product.isActive()) {
            throw new BadRequestException("Product is not active");
        }
        
        List<InventoryLevel> inventories = inventoryLevelRepository.findByProduct_Id(productId);
        List<DemandForecast> forecasts = demandForecastRepository.findByProduct_Id(productId);
        
        List<TransferSuggestion> suggestions = new ArrayList<>();
        
        // Simple balancing logic: find stores with excess and deficit
        for (InventoryLevel inv : inventories) {
            if (inv.getQuantity() > 100) { // Excess threshold
                for (InventoryLevel other : inventories) {
                    if (!inv.getStore().getId().equals(other.getStore().getId()) && other.getQuantity() < 20) {
                        TransferSuggestion suggestion = new TransferSuggestion();
                        suggestion.setProduct(product);
                        suggestion.setSourceStore(inv.getStore());
                        suggestion.setTargetStore(other.getStore());
                        suggestion.setSuggestedQuantity(Math.min(50, inv.getQuantity() - 50));
                        suggestion.setReason("Balancing inventory levels");
                        suggestions.add(transferSuggestionRepository.save(suggestion));
                    }
                }
            }
        }
        
        return suggestions;
    }

    public TransferSuggestion getSuggestionById(Long id) {
        return transferSuggestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transfer suggestion not found"));
    }
}
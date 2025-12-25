package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.InventoryBalancerService;

import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final InventoryLevelRepository invRepo;
    private final ProductRepository productRepo;
    private final TransferSuggestionRepository tsRepo;

    public InventoryBalancerServiceImpl(
            InventoryLevelRepository invRepo,
            ProductRepository productRepo,
            TransferSuggestionRepository tsRepo) {
        this.invRepo = invRepo;
        this.productRepo = productRepo;
        this.tsRepo = tsRepo;
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (!product.isActive())
            throw new BadRequestException("Inactive product");

        List<InventoryLevel> inventory = invRepo.findByProduct_Id(productId);
        if (inventory.size() < 2)
            return List.of();

        InventoryLevel max = inventory.stream()
                .max(Comparator.comparingInt(InventoryLevel::getQuantity)).get();

        InventoryLevel min = inventory.stream()
                .min(Comparator.comparingInt(InventoryLevel::getQuantity)).get();

        if (max.getQuantity() <= min.getQuantity())
            return List.of();

        TransferSuggestion ts = new TransferSuggestion();
        ts.setProduct(product);
        ts.setSourceStore(max.getStore());
        ts.setTargetStore(min.getStore());
        ts.setSuggestedQuantity((max.getQuantity() - min.getQuantity()) / 2);
        ts.setReason("Auto balancing");

        return List.of(tsRepo.save(ts));
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return tsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }
}

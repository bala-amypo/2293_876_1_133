package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final TransferSuggestionRepository suggestionRepo;
    private final InventoryLevelRepository inventoryRepo;
    private final DemandForecastRepository forecastRepo;
    private final StoreRepository storeRepo;

    public InventoryBalancerServiceImpl(
            TransferSuggestionRepository suggestionRepo,
            InventoryLevelRepository inventoryRepo,
            DemandForecastRepository forecastRepo,
            StoreRepository storeRepo
    ) {
        this.suggestionRepo = suggestionRepo;
        this.inventoryRepo = inventoryRepo;
        this.forecastRepo = forecastRepo;
        this.storeRepo = storeRepo;
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        List<InventoryLevel> inventories =
                inventoryRepo.findByProduct_Id(productId);

        if (inventories.isEmpty()) {
            throw new BadRequestException("No forecast found");
        }

        List<TransferSuggestion> results = new ArrayList<>();

        InventoryLevel max = inventories.get(0);
        InventoryLevel min = inventories.get(0);

        for (InventoryLevel i : inventories) {
            if (i.getQuantity() > max.getQuantity()) max = i;
            if (i.getQuantity() < min.getQuantity()) min = i;
        }

        List<DemandForecast> forecasts =
                forecastRepo.findByStoreAndProductAndForecastDateAfter(
                        min.getStore(),
                        min.getProduct(),
                        LocalDate.now()
                );

        if (forecasts.isEmpty()) {
            throw new BadRequestException("No forecast found");
        }

        if (max.getQuantity() > min.getQuantity()) {
            TransferSuggestion ts = new TransferSuggestion();
            ts.setSourceStore(max.getStore());
            ts.setTargetStore(min.getStore());
            ts.setProduct(max.getProduct());
            ts.setQuantity((max.getQuantity() - min.getQuantity()) / 2);
            ts.setPriority("HIGH");

            results.add(suggestionRepo.save(ts));
        }

        return results;
    }

    @Override
    public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {
        return suggestionRepo.findBySourceStoreId(storeId);
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return suggestionRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Suggestion not found"));
    }
}

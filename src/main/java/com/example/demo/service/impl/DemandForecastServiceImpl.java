package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DemandForecast;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.service.DemandForecastService;

@Service
public class DemandForecastServiceImpl implements DemandForecastService {

    private final DemandForecastRepository repository;

    public DemandForecastServiceImpl(DemandForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public DemandForecast createForecast(DemandForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public List<DemandForecast> getForecastByStore(Long storeId) {
        return repository.findByStore_Id(storeId);
    }

    @Override
    public List<DemandForecast> getForecastByProduct(Long productId) {
        return repository.findByProduct_Id(productId);
    }
}

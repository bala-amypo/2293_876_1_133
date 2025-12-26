package com.example.demo.service.impl;

import com.example.demo.entity.DemandForecast;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.service.DemandForecastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandForecastServiceImpl implements DemandForecastService {

    private final DemandForecastRepository repo;

    public DemandForecastServiceImpl(DemandForecastRepository repo) {
        this.repo = repo;
    }

    public DemandForecast saveForecast(DemandForecast forecast) {
        return repo.save(forecast);
    }

    public List<DemandForecast> findByStoreId(Long storeId) {
        return repo.findAll();
    }
}

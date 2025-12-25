package com.example.demo.service;

import com.example.demo.entity.DemandForecast;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.DemandForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DemandForecastService {
    @Autowired
    private DemandForecastRepository demandForecastRepository;

    public DemandForecast createForecast(DemandForecast forecast) {
        if (forecast.getForecastDate().isBefore(LocalDate.now())) {
            throw new BadRequestException("Forecast date cannot be in the past");
        }
        return demandForecastRepository.save(forecast);
    }

    public List<DemandForecast> getForecastsForStore(Long storeId) {
        return demandForecastRepository.findByStore_Id(storeId);
    }
}
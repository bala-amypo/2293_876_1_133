package com.example.demo.service;

import com.example.demo.entity.DemandForecast;
import java.util.List;

public interface DemandForecastService {
    DemandForecast saveForecast(DemandForecast forecast);
    List<DemandForecast> getForecastsForStore(Long storeId);
}

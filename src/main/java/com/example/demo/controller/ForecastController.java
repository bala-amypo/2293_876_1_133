package com.example.demo.controller;

import com.example.demo.entity.DemandForecast;
import com.example.demo.service.ForecastService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forecasts")
public class ForecastController {

    private final ForecastService service;

    public ForecastController(ForecastService service) {
        this.service = service;
    }

    @PostMapping
    public DemandForecast create(@RequestBody DemandForecast forecast) {
        return service.create(forecast);
    }
}

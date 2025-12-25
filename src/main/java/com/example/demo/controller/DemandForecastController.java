// package com.example.demo.controller;

// import java.util.List;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.entity.DemandForecast;
// import com.example.demo.service.DemandForecastService;

// @RestController
// @RequestMapping("/api/forecasts")
// public class DemandForecastController {

//     private final DemandForecastService service;

//     public DemandForecastController(DemandForecastService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public DemandForecast create(@RequestBody DemandForecast forecast) {
//         return service.createForecast(forecast);
//     }

//     @GetMapping("/store/{storeId}")
//     public List<DemandForecast> byStore(@PathVariable Long storeId) {
//         return service.getForecastByStore(storeId);
//     }

//     @GetMapping("/product/{productId}")
//     public List<DemandForecast> byProduct(@PathVariable Long productId) {
//         return service.getForecastByProduct(productId);
//     }
// }

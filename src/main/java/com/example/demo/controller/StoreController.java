package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @PostMapping
    public Store create(@RequestBody Store store) {
        return service.createStore(store);
    }

    @GetMapping
    public List<Store> getAll() {
        return service.getStores();
    }
}

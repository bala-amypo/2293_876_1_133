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
    public Store save(@RequestBody Store store) {
        return service.save(store);
    }

    @GetMapping("/{id}")
    public Store getById(@PathVariable Long id) {
        return service.getStoreById(id);
    }

    @GetMapping
    public List<Store> getAll() {
        return service.getStores();
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public Store create(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @GetMapping("/{id}")
    public Store getById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @GetMapping
    public List<Store> getAll() {
        return storeService.getAllStores();
    }

    @PutMapping("/{id}")
    public Store update(
            @PathVariable Long id,
            @RequestBody Store store) {
        return storeService.updateStore(id, store);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        storeService.deactivateStore(id);
    }
}

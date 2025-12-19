package com.example.inventory.controller;

import com.example.inventory.model.Store;
import com.example.inventory.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store savedStore = storeService.createStore(store);
        return new ResponseEntity<>(savedStore, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        Store store = storeService.getStoreById(id);
        return ResponseEntity.ok(store);
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(
            @PathVariable Long id,
            @RequestBody Store store) {

        Store updatedStore = storeService.updateStore(id, store);
        return ResponseEntity.ok(updatedStore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deactivateStore(@PathVariable Long id) {
        storeService.deactivateStore(id);
        return ResponseEntity.ok("Store deactivated successfully");
    }
}

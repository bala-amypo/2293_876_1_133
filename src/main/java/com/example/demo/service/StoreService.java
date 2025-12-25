package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
    }

    public Store updateStore(Long id, Store storeUpdate) {
        Store store = getStoreById(id);
        store.setStoreName(storeUpdate.getStoreName());
        store.setAddress(storeUpdate.getAddress());
        store.setRegion(storeUpdate.getRegion());
        if (storeUpdate.isActive() != store.isActive()) {
            store.setActive(storeUpdate.isActive());
        }
        return storeRepository.save(store);
    }

    public void deactivateStore(Long id) {
        Store store = getStoreById(id);
        store.setActive(false);
        storeRepository.save(store);
    }
}
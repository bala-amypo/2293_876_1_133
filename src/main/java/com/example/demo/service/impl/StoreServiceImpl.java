package com.example.inventory.service.impl;

import com.example.inventory.model.Store;
import com.example.inventory.repository.StoreRepository;
import com.example.inventory.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store createStore(Store store) {
        store.setActive(true); // ensure store is active when created
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store updateStore(Long id, Store update) {
        Store existingStore = getStoreById(id);

        existingStore.setStoreName(update.getStoreName());
        existingStore.setAddress(update.getAddress());
        existingStore.setRegion(update.getRegion());
        existingStore.setActive(update.getActive());

        return storeRepository.save(existingStore);
    }

    @Override
    public void deactivateStore(Long id) {
        Store store = getStoreById(id);
        store.setActive(false);
        storeRepository.save(store);
    }
}

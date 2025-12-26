package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store updateStore(Long id, Store store) {
        store.setId(id);
        return storeRepository.save(store);
    }

    @Override
    public void deactivateStore(Long id) {
        Store store = storeRepository.findById(id).orElseThrow();
        store.setActive(false);
        storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow();
    }
}

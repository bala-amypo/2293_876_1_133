package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository repository;

    public StoreServiceImpl(StoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Store createStore(Store store) {
        store.setActive(true);
        return repository.save(store);
    }

    @Override
    public List<Store> getStores() {
        return repository.findAll();
    }

    @Override
    public Store updateStore(Long id, Store store) {
        store.setId(id);
        return repository.save(store);
    }

    @Override
    public void deactivateStore(Long id) {
        Store store = repository.findById(id).orElseThrow();
        store.setActive(false);
        repository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}

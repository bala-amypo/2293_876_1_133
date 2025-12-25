package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository repository;

    public StoreServiceImpl(StoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Store createStore(Store store) {
        return repository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Store> getAllStores() {
        return repository.findAll();
    }
}

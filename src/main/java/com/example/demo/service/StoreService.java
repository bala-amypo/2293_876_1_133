package com.example.demo.service;

import com.example.demo.entity.Store;

public interface StoreService {
    Store createStore(Store store);
    Store updateStore(Long id, Store store);
    void deactivateStore(Long id);
    Store getStoreById(Long id);
}

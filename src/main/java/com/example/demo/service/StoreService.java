package com.example.inventory.service;

import com.example.inventory.model.Store;

import java.util.List;

public interface StoreService {

    Store createStore(Store store);

    Store getStoreById(Long id);

    List<Store> getAllStores();

    Store updateStore(Long id, Store update);

    void deactivateStore(Long id);
}

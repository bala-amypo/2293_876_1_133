package com.example.demo.service;

import com.example.demo.entity.Store;
import java.util.List;

public interface StoreService {

    Store createStore(Store store);     // 👈 ADD
    List<Store> getStores();             // 👈 ADD

    Store updateStore(Long id, Store store);
    void deactivateStore(Long id);
    Store getStoreById(Long id);
}

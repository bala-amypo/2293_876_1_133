package com.example.demo.service;

import com.example.demo.entity.Store;
import java.util.List;

public interface StoreService {
    Store save(Store store);
    Store getStoreById(Long id);
    List<Store> getStores();
}

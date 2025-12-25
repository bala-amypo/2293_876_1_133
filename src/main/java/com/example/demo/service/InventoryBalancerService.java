package com.example.demo.service;
import com.example.demo.service.InventoryBalancerService;

import org.springframework.stereotype.Service;

@Service
public class InventoryBalancerService {

    public String balanceInventory() {
        return "Inventory balanced";
    }
}

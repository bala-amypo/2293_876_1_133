// package com.example.demo.service.impl;

// import com.example.demo.entity.InventoryLevel;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.repository.InventoryLevelRepository;
// import com.example.demo.service.InventoryService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class InventoryServiceImpl implements InventoryService {

//     private final InventoryLevelRepository repository;

//     public InventoryServiceImpl(InventoryLevelRepository repository) {
//         this.repository = repository;
//     }

//     public InventoryLevel saveInventory(InventoryLevel inventory) {
//         if (inventory.getQuantity() < 0) {
//             throw new BadRequestException("Quantity cannot be negative");
//         }

//         List<InventoryLevel> existing =
//                 repository.findByStore_Id(inventory.getStore().getId());

//         for (InventoryLevel inv : existing) {
//             if (inv.getProduct().getId().equals(inventory.getProduct().getId())) {
//                 inv.setQuantity(inventory.getQuantity());
//                 return repository.save(inv);
//             }
//         }
//         return repository.save(inventory);
//     }

//     public List<InventoryLevel> getByStore(Long storeId) {
//         return repository.findByStore_Id(storeId);
//     }
// }

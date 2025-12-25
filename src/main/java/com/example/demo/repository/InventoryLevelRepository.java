package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.InventoryLevel;

public interface InventoryLevelRepository extends JpaRepository<InventoryLevel, Long> {

    List<InventoryLevel> findByStore_Id(Long storeId);

    List<InventoryLevel> findByProduct_Id(Long productId);
}

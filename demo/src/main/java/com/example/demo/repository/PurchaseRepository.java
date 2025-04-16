package com.example.demo.repository;

import com.example.demo.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findBySupplierId(Long supplierId);

    List<Purchase> findByProductId(Long productId);
}

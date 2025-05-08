package com.moliendafina.backend.repository;

import com.moliendafina.backend.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findBySupplierId(Long supplierId);

    List<Purchase> findByProductId(Long productId);
}

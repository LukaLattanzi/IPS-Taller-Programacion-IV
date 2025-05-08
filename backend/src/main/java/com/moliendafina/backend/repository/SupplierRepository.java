package com.moliendafina.backend.repository;

import com.moliendafina.backend.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

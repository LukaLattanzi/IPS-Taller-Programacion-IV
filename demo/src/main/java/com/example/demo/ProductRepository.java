package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Buscar por nombre (ignorando mayúsculas/minúsculas)
    List<Product> findByNameContainingIgnoreCase(String name);

    // Consulta personalizada para productos con stock bajo
    @Query("SELECT p FROM Product p WHERE p.stock < p.minStock")
    List<Product> findLowStockProducts();

    // Alternativa usando derivación de métodos:
    // List<Product> findByStockLessThan(Integer minStock);
}

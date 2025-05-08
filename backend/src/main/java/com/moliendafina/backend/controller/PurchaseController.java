package com.moliendafina.backend.controller;

import com.moliendafina.backend.model.Purchase;
import com.moliendafina.backend.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Purchase getPurchaseById(@PathVariable Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @GetMapping("/by-supplier/{supplierId}")
    public List<Purchase> getBySupplier(@PathVariable Long supplierId) {
        return purchaseRepository.findBySupplierId(supplierId);
    }

    @GetMapping("/by-product/{productId}")
    public List<Purchase> getByProduct(@PathVariable Long productId) {
        return purchaseRepository.findByProductId(productId);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable Long id) {
        purchaseRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllPurchases() {
        purchaseRepository.deleteAll();
    }
}
package com.moliendafina.backend.controller;

import com.moliendafina.backend.model.Supplier;
import com.moliendafina.backend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier data) {
        return supplierRepository.findById(id).map(s -> {
            s.setCompanyName(data.getCompanyName());
            s.setContactName(data.getContactName());
            s.setPhone(data.getPhone());
            s.setEmail(data.getEmail());
            return supplierRepository.save(s);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllSuppliers() {
        supplierRepository.deleteAll();
    }
}

package com.moliendafina.backend.controller;

import com.moliendafina.backend.repository.ProductRepository;
import com.moliendafina.backend.repository.CategoryRepository;
import com.moliendafina.backend.repository.ClientRepository;
import com.moliendafina.backend.repository.OrderDetailRepository;
import com.moliendafina.backend.repository.OrderRepository;
import com.moliendafina.backend.repository.PurchaseRepository;
import com.moliendafina.backend.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("compras", purchaseRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("orderDetails", orderDetailRepository.findAll());

        return "dashboard";
    }
}
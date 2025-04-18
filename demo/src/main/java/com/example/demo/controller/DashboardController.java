package com.example.demo.controller;

import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.PurchaseRepository;
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

    /**
     * Maneja la solicitud GET para la página del dashboard.
     * Pasa los datos de todas las entidades al modelo para renderizar en el HTML.
     *
     * @param model Objeto Model para pasar datos a la vista.
     * @return El nombre del archivo HTML a renderizar ("dashboard").
     */
    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        // Agregar datos de productos
        model.addAttribute("products", productRepository.findAll());

        // Agregar datos de categorías
        model.addAttribute("categories", categoryRepository.findAll());

        // Agregar datos de clientes
        model.addAttribute("clients", clientRepository.findAll());

        // Agregar datos de compras
        model.addAttribute("compras", purchaseRepository.findAll());

        // Renderizar la vista "dashboard.html"
        return "dashboard";
    }
}
package com.example.backend.controller;

import com.example.backend.repository.ProductRepository;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.OrderDetailRepository;
import com.example.backend.repository.OrderRepository;
import com.example.backend.repository.PurchaseRepository;
import com.example.backend.repository.SupplierRepository;

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

        // Agregar datos de proveedores
        model.addAttribute("suppliers", supplierRepository.findAll());

        // Agregar datos de pedidos
        model.addAttribute("orders", orderRepository.findAll());

        // Agregar datos de detalles de pedido
        model.addAttribute("orderDetails", orderDetailRepository.findAll());

        // Renderizar la vista "dashboard.html"
        return "dashboard";
    }
}
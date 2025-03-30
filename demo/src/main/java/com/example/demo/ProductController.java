package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Controlador GET para obtener todos los productos | curl http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Controlador GET para obtener un producto por ID | curl http://localhost:8080/api/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    // Controlador POST para crear un nuevo producto | curl -X POST -H "Content-Type: application/json" -d '{"name":"Producto 1", "price":10.0}' http://localhost:8080/api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Controlador PUT para actualizar un producto existente | curl -X PUT -H "Content-Type: application/json" -d '{"name":"Producto 1 actualizado", "price":15.0}' http://localhost:8080/api/products/1
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    // Controlador DELETE para eliminar un producto por ID | curl -X DELETE http://localhost:8080/api/products/1
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        productRepository.delete(product);
    }

    // Controlador DELETE para eliminar todos los productos | curl -X DELETE http://localhost:8080/api/products
    @DeleteMapping
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
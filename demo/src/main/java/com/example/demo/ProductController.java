package com.example.demo;

// Importa las anotaciones de Spring necesarias para crear un controlador REST.
import org.springframework.beans.factory.annotation.Autowired; // Permite la inyección automática de dependencias.
import org.springframework.web.bind.annotation.*; // Importa las anotaciones necesarias para manejar peticiones HTTP (GET, POST, etc.).

import java.util.List;

@RestController // Indica que esta clase es un controlador REST, y que los métodos devuelven
                // directamente datos (por ejemplo, JSON).
@RequestMapping("/api/products") // Define la ruta base para todas las solicitudes manejadas por este
                                 // controlador.
public class ProductController {

    @Autowired // Inyecta automáticamente una instancia de ProductRepository para interactuar
               // con la base de datos.
    private ProductRepository productRepository;

    // Obtener todos los productos o buscar productos por nombre si se proporciona
    // el parámetro "search".
    @GetMapping
    public List<Product> getAllProducts(@RequestParam(value = "search", required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(search);
        }
        return productRepository.findAll();
    }

    // Obtener un producto por su ID.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    // Crear un nuevo producto.
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Actualizar un producto existente.
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        return productRepository.save(product);
    }

    // Actualizar solamente el stock de un producto.
    @PatchMapping("/{id}/stock")
    public Product updateStock(@PathVariable Long id, @RequestParam double kilos) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        double newStock = product.getStock() + kilos;
        if (newStock < 0) {
            throw new RuntimeException("El stock no puede ser negativo.");
        }

        product.setStock(newStock);
        return productRepository.save(product);
    }

    // Eliminar todos los productos de la base de datos.
    @DeleteMapping
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        productRepository.delete(product);
    }
}

/*
 * === USOS EN CURL ===
 * 
 * # Obtener todos los productos
 * curl -X GET http://localhost:8080/api/products
 * 
 * # Obtener un producto por ID
 * curl -X GET http://localhost:8080/api/products/{id}
 * 
 * # Crear un nuevo producto
 * curl -X POST -H "Content-Type: application/json" -d '{"name":"Producto 1",
 * "price": 10.0, "stock": 100}' http://localhost:8080/api/products
 * 
 * # Actualizar un producto existente
 * curl -X PUT -H "Content-Type: application/json" -d
 * '{"name":"Producto 1 actualizado", "price": 15.0, "stock": 50}'
 * http://localhost:8080/api/products/{id}
 * 
 * # Actualizar el stock de un producto
 * curl -X PATCH http://localhost:8080/api/products/{id}/stock?kilos=10
 * 
 * # Eliminar un producto por ID
 * curl -X DELETE http://localhost:8080/api/products/{id}
 * 
 * # Eliminar todos los productos
 * curl -X DELETE http://localhost:8080/api/products
 */
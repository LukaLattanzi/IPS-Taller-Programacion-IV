package com.example.demo;

// Importa las anotaciones necesarias para definir un controlador REST.
import org.springframework.beans.factory.annotation.Autowired; // Permite la inyección automática de dependencias.
import org.springframework.web.bind.annotation.*; // Proporciona las anotaciones para manejar solicitudes HTTP (GET, POST, PUT, DELETE, etc.).

// Importa las clases necesarias para manejar listas.
import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con los productos.
 * Proporciona endpoints para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar).
 */

@RestController // Marca esta clase como un controlador REST, lo que permite manejar solicitudes
                // HTTP.
@RequestMapping("/api/products") // Define la ruta base para todos los endpoints de este controlador.
public class ProductController {

    // Inyección automática del repositorio de productos para interactuar con la
    // base de datos.
    @Autowired
    private ProductRepository productRepository;

    @GetMapping // @GetMapping: se utiliza para manejar solicitudes HTTP GET. Ideal para obtener
                // datos sin modifica el estado del servidor.
    public List<Product> getAllProducts() { // Método para obtener todos los productos.
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) { // Metodo para obtener un producto por su ID.
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @PostMapping // @PostMapping: se utiliza para manejar solicitudes HTTP POST. Ideal para crear
                 // nuevos recursos en el servidor.
    public Product createProduct(@RequestBody Product product) { // Método para crear un nuevo producto.
        return productRepository.save(product);
    }

    @PutMapping("/{id}") // @PutMapping: se utiliza para manejar solicitudes HTTP PUT. Ideal para
                         // actualizar un recurso existente en el servidor.
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) { // Método para actualizar
                                                                                               // un producto existente.
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        return productRepository.save(product);
    }

    @PatchMapping("/{id}/stock") // @PatchMapping: se utiliza para manejar solicitudes HTTP PATCH. Ideal para
                                 // realizar actualizaciones parciales de un recurso.
    public Product updateStock(@PathVariable Long id, @RequestParam double kilos) { // Método para actualizar el stock
                                                                                    // de un producto.
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        double newStock = product.getStock() + kilos;
        if (newStock < 0) {
            throw new RuntimeException("El stock no puede ser negativo.");
        }

        product.setStock(newStock);
        return productRepository.save(product);
    }

    @DeleteMapping // @DeleteMapping: se utiliza para manejar solicitudes HTTP DELETE. Ideal para
                   // eliminar recursos del servidor.
    public void deleteAllProducts() { // Método para eliminar todos los productos.
        productRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) { // Método para eliminar un producto por su ID.
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        productRepository.delete(product);
    }
}

/*
 * Usos en CURL
 * 
 * # Obtener todos los productos
 * curl -X GET http://localhost:8080/api/products
 * 
 * # Obtener un producto por ID
 * curl -X GET http://localhost:8080/api/products/id
 * 
 * # Crear un nuevo producto
 * curl -X POST -H "Content-Type: application/json" -d '{"name":"Producto 1", "price": 10.0, "stock": 100}' http://localhost:8080/api/products
 * 
 * # Actualizar un producto existente
 * curl -X PUT -H "Content-Type: application/json" -d '{"name":"Producto 1 actualizado", "price": 15.0, "stock": 50}' http://localhost:8080/api/products/id
 * 
 * # Actualizar el stock de un producto
 * curl -X PATCH -H "Content-Type: application/json" -d '{"kilos": 10}' http://localhost:8080/api/products/id/stock
 * 
 * # Eliminar un producto por ID
 * curl -X DELETE http://localhost:8080/api/products/id
 * 
 * # Eliminar todos los productos
 * curl -X DELETE http://localhost:8080/api/products
 */
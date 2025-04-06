package com.example.demo;

// Importa la interfaz JpaRepository de Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository proporciona métodos predefinidos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
// y consultas avanzadas sobre la entidad sin necesidad de escribir implementación manual.

// Importa la clase necesaria para manejar listas.
import java.util.List;

/*
 * Interfaz ProductRepository.
 * 
 * Esta interfaz extiende JpaRepository, permitiendo interactuar con la base de datos
 * para realizar operaciones CRUD y consultas relacionadas con la entidad Product.
 * 
 * Al extender JpaRepository, esta interfaz hereda métodos como:
 * - save(): Guardar o actualizar un producto.
 * - findById(): Buscar un producto por su ID.
 * - findAll(): Obtener todos los productos.
 * - deleteById(): Eliminar un producto por su ID.
 * - deleteAll(): Eliminar todos los productos.
 * 
 * Spring Data JPA se encarga de generar automáticamente la implementación de esta interfaz
 * en tiempo de ejecución, por lo tanto, no es necesario escribir código adicional.
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
     * Buscar productos cuyo nombre contenga el texto proporcionado,
     * sin distinguir entre mayúsculas y minúsculas.
     * 
     * @param name Texto a buscar dentro del nombre del producto.
     * 
     * @return Lista de productos cuyo nombre contenga el texto buscado.
     */
    List<Product> findByNameContainingIgnoreCase(String name);
}
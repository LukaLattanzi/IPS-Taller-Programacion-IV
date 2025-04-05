package com.example.demo;

// Importa la interfaz JpaRepository de Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository proporciona métodos predefinidos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
// y consultas avanzadas en la base de datos sin necesidad de implementar manualmente estas operaciones.

/*
 * Interfaz ProductRepository.
 * 
 * Esta interfaz extiende JpaRepository, lo que permite interactuar con la base
 * de datos
 * para realizar operaciones CRUD y consultas relacionadas con la entidad
 * Product.
 * 
 * Al extender JpaRepository, esta interfaz hereda métodos predefinidos como:
 * - save(): Guardar o actualizar una entidad.
 * - findById(): Buscar una entidad por su ID.
 * - findAll(): Obtener todas las entidades.
 * - deleteById(): Eliminar una entidad por su ID.
 * - deleteAll(): Eliminar todas las entidades.
 * 
 * No es necesario implementar esta interfaz, ya que Spring Data JPA genera
 * automáticamente
 * la implementación en tiempo de ejecución.
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
}
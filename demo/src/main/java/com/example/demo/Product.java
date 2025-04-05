package com.example.demo;

// Importa las anotaciones de JPA necesarias para mapear esta clase como una entidad en la base de datos.
import jakarta.persistence.Entity; // Indica que esta clase es una entidad JPA y se mapeará a una tabla en la base de datos.
import jakarta.persistence.GeneratedValue; // Permite la generación automática del valor del ID.
import jakarta.persistence.GenerationType; // Especifica la estrategia de generación del ID (por ejemplo, AUTO_INCREMENT).
import jakarta.persistence.Id; // Marca el atributo como clave primaria de la tabla.

// Importa las anotaciones de Lombok para reducir el código boilerplate.
import lombok.AllArgsConstructor; // Genera automáticamente un constructor con todos los atributos de la clase.
import lombok.Data; // Genera automáticamente los métodos getter, setter, toString, equals y hashCode.

@Entity
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double stock;
}
package com.example.demo;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Productos") // Nombre exacto de la tabla en MySQL
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String description;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_actual", nullable = false)
    private Integer stock;

    @Column(name = "stock_minimo", nullable = false)
    private Integer minStock = 5;

    @Column(name = "fecha_creacion", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private String creationDate; // Usar String o LocalDateTime según necesidad

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "FK_producto_categoria"))
    private Category category;
}
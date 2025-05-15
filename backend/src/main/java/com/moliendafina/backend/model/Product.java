package com.moliendafina.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
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

    @Column(name = "fecha_creacion", insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String creationDate;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "FK_producto_categoria"))
    @JsonBackReference
    private Category category;
}

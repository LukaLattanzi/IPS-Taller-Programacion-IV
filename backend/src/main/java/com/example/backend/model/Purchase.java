package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "compras")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_proveedor"))
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_producto"))
    private Product product;

    @Column(name = "cantidad", nullable = false)
    private Integer quantity;

    @Column(name = "costo_unitario", nullable = false)
    private BigDecimal unitCost;

    @Column(name = "fecha_compra", insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String purchaseDate;
}

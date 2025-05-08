package com.moliendafina.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_pedido_cliente"))
    private Client client;

    @Column(name = "fecha_pedido", insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String orderDate;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDIENTE;

    @Column(name = "total", nullable = false)
    private BigDecimal total = BigDecimal.ZERO;
}

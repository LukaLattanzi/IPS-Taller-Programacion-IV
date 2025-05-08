package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Long id;

    @Column(name = "nombre_empresa", nullable = false)
    private String companyName;

    @Column(name = "contacto_nombre")
    private String contactName;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "email")
    private String email;
}

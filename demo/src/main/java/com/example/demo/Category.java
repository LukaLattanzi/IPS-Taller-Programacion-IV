package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categorias")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;

    @Column(name = "nombre_categoria", unique = true, nullable = false)
    private String name;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String description;
}
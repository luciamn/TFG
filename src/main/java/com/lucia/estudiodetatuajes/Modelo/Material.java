package com.lucia.estudiodetatuajes.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoria", nullable = true)
    private CategoriaMaterial categoriaMaterial;

    @OneToOne
    @JoinColumn(name = "personal", nullable = true)
    private Personal personal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="proveedor", nullable = true)
    private Proveedor proveedor;
}

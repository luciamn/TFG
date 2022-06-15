package com.lucia.estudiodetatuajes.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="nombre", nullable = false)
    private String nombre;

    @Column(name =  "precio", nullable = false)
    private double precio;

    @Column(name = "descripcion", nullable = false, length = 600)
    private String descripcion;

    @Column(name = "imagen", nullable = false)
    private String imagen;


//    @ManyToMany
//    @JoinTable(
//            name = "compra",
//            joinColumns = {@JoinColumn(name = "producto_id")},
//            inverseJoinColumns = {@JoinColumn(name = "cliente_id")}
//    )
//
//    private List<Cliente> cliente;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Compra compra;


    public Producto(String nombre, double precio, String descripcion, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
}
package com.lucia.estudiodetatuajes.Modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "turno", nullable = false)
    private String turno;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="especialidad", nullable = true)
    private TipoTatuaje tipoTatuaje;

    @OneToMany
    @JoinColumn(name = "material")
    private List<Material> material;


    public Personal(String nombre, String apellidos, String dni, String telefono, String turno, TipoTatuaje tipoTatuaje) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.turno = turno;
        this.tipoTatuaje = tipoTatuaje;
    }

    public Personal() {

    }

    @Override
    public String toString() {
        return "Personal{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }
}

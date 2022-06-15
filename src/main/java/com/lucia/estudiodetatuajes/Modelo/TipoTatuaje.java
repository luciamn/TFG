package com.lucia.estudiodetatuajes.Modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_Tatuaje")
public class TipoTatuaje {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public TipoTatuaje(String tipo) {
        this.tipo = tipo;
    }

}

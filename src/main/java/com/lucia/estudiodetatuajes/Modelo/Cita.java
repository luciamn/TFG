package com.lucia.estudiodetatuajes.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Personal;
import jdk.jfr.Timespan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fecha;

    @DateTimeFormat(pattern = "HH:MM")
    private String hora;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "zona", nullable = true)
    private String zonaDelCuerpo;

    @Column(name = "tamano", nullable = true)
    private int tamano;

    @Column(name = "tipo", nullable = true)
    private String tipo;

    @Column(name = "foto", nullable = true)
    private String foto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tatuador", nullable = true)
    private Personal personal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente", nullable = true)
    private Cliente cliente;
}

package com.lucia.estudiodetatuajes.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micrometer.core.annotation.Counted;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @ManyToOne
    private Cliente cliente;

    public Compra(Cliente cliente) {
        this.cliente = cliente;
    }
}
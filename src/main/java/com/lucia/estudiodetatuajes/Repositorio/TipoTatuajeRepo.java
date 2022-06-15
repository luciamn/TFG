package com.lucia.estudiodetatuajes.Repositorio;


import com.lucia.estudiodetatuajes.Modelo.TipoTatuaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTatuajeRepo extends JpaRepository <TipoTatuaje, Long> {

    public TipoTatuaje findByTipo(String tipo);
}

package com.lucia.estudiodetatuajes.Servicio;


import com.lucia.estudiodetatuajes.Modelo.TipoTatuaje;
import com.lucia.estudiodetatuajes.Repositorio.TipoTatuajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTatuajeServicio {

    @Autowired
    private TipoTatuajeRepo tipoTatuajeRepo;


    public TipoTatuaje findByTipo(String tipo){
        return tipoTatuajeRepo.findByTipo(tipo);
    }
}

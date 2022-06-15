package com.lucia.estudiodetatuajes.Repositorio;


import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Personal;
import com.lucia.estudiodetatuajes.Modelo.TipoTatuaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonalRepo extends JpaRepository<Personal, Long> {

    //public Personal findByTurnoAndTipoTatuaje(String turno, TipoTatuaje tipoTatuaje);

    public Personal findByTipoTatuaje(TipoTatuaje tipoTatuaje);


    public Personal findByDni(String dni);




    public Optional<Personal> findById(Long id);



}

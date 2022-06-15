package com.lucia.estudiodetatuajes.Repositorio;


import com.lucia.estudiodetatuajes.Modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Long> {
    public ArrayList<Cita>findAllByClienteId(Long id);


    @Query(value = "select * from cita", nativeQuery = true)
    public List<Cita> citas();


    //citas de un cliente
    @Query(value = "select * from cita where cliente = ?1", nativeQuery = true)
    public List<Cita> citasCliente(int id);
    }



    //select * from cita c join cliente cl on c.id = cl.id where cliente = ?;

    //select * from cita where cliente = ?1;

    //select * from cita where cliente = ?1
    //select * from cita c join personal p on c.id = p.id  where cliente = ?1


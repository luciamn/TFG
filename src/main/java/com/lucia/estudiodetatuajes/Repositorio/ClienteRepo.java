package com.lucia.estudiodetatuajes.Repositorio;


import com.lucia.estudiodetatuajes.Modelo.Cita;
import com.lucia.estudiodetatuajes.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {

     Cliente findFirstByEmail(String email);

     //sacar todos los clientes de la app
     @Query(value = "select count(*) from cliente", nativeQuery = true)
     public int clientes();


}

package com.lucia.estudiodetatuajes.Repositorio;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepo extends JpaRepository<Compra, Long> {

    //todas las compras de un usuario
    List<Compra> findByCliente(Cliente cliente);




}

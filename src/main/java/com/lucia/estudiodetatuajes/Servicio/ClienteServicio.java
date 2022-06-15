package com.lucia.estudiodetatuajes.Servicio;


import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Repositorio.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepo clienteRepo;

    /**@Autowired
    private BCryptPasswordEncoder passwordEncoder ;*/


    //registarar un cliente
    public Cliente registrar (Cliente cliente, BCryptPasswordEncoder bCryptPasswordEncoder){
        cliente.setContrasena(bCryptPasswordEncoder.encode(cliente.getContrasena()));
        return  clienteRepo.save(cliente);
    }

    public Cliente findByEmail(String email){
        return clienteRepo.findFirstByEmail(email);
    }

    public Cliente findById(long id){
        return clienteRepo.findById(id).orElse(null);
    }




    /**@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

        public ArrayList<Cliente> obtenerClientes(){
        return (ArrayList<Cliente>) clienteRepo.findAll();
    }


    public Cliente registrar(Cliente cliente) {
          return   clienteRepo.save(cliente);
    }
}

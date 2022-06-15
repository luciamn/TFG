package com.lucia.estudiodetatuajes.Servicio;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Compra;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Repositorio.CompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CompraServicio {

    @Autowired
    CompraRepo compraRepo;

    @Autowired
    ProductoServicio productoServicio;

    public Compra insertar(Compra compra, HttpSession session){
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        compra.setCliente(cliente);
        return compraRepo.save(compra);
    }

    public Compra insertar(Compra c){
        return compraRepo.save(c);
    }

    public Producto addProductoCompra(Producto p, Compra c){
        p.setCompra(c);
        return productoServicio.editar(p);
    }

    public Compra buscarPorId(long id){
        return compraRepo.findById(id).orElse(null);
    }

    public List<Compra> todas(){
        return compraRepo.findAll();
    }

    public List<Compra> porCliente(Cliente cliente){
        return compraRepo.findByCliente(cliente);
    }
}
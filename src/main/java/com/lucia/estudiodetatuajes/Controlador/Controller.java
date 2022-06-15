package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Repositorio.CompraRepo;
import com.lucia.estudiodetatuajes.Repositorio.ProductoRepo;
import com.lucia.estudiodetatuajes.Servicio.ClienteServicio;
import com.lucia.estudiodetatuajes.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    CompraRepo compraRepo;

    @Autowired
    ProductoRepo productoRepo;

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    ClienteServicio clienteServicio;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }

    @GetMapping("/galeria")
    public String galeria(){
        return "galeria";
    }

    @GetMapping("/admin2")
    public String admin2(){
        return "FormPersonal";
    }


    @GetMapping("/estudio")
    public String estudio(){
        return "estudio";
    }











}
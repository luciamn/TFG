package com.lucia.estudiodetatuajes.Controlador;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.lucia.estudiodetatuajes.Repositorio.CitaRepo;
import com.lucia.estudiodetatuajes.Repositorio.ClienteRepo;
import com.lucia.estudiodetatuajes.Repositorio.CompraRepo;
import com.lucia.estudiodetatuajes.Repositorio.ProductoRepo;
import com.lucia.estudiodetatuajes.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DatosRestContoller {

    @Autowired
    CitaRepo citaRepo;

    @Autowired
    ProductoRepo productoRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    CompraRepo compraRepo;

    @GetMapping("/datos")
    public HashMap<String, Object> getDatos(){
        long lProductCount = productoRepo.count();
        long lClientCount = clienteRepo.count();
        long lCompraCount = compraRepo.count();
        long lCitaCount = citaRepo.count();

        HashMap<String, Object> map = new HashMap<>();
        map.put("count_product", lProductCount);
        map.put("count_users", lClientCount);
        map.put("count_compras", lCompraCount);
        map.put("count_citas", lCitaCount);

        return map;
}
}

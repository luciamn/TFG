package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Servicio.ClienteServicio;
import com.lucia.estudiodetatuajes.Servicio.ProductoServicio;
import com.lucia.estudiodetatuajes.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app")
public class ProductoController {

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    ClienteServicio clienteServicio;

    private Cliente cliente;

    @Autowired
    StorageService storageService;


    @ModelAttribute("misproductos")
    public List<Producto> misProductos() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        cliente = clienteServicio.findByEmail(email);
        return productoServicio.productoDeUnPropietario(cliente);
    }

    @GetMapping("/misproductos")
    public String list(Model model, @RequestParam(name = "q", required = false)String query){
        if (query != null){
            model.addAttribute("misproducto", productoServicio.buscarMisProductos(query, cliente));
        }
        return "app/producto/lista";
    }








}

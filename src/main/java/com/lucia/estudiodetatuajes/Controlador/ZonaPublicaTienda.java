package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/public")
public class ZonaPublicaTienda {

    @Autowired
    ProductoServicio productoServicio;


    @ModelAttribute("productos")
    public List<Producto> productos(){
        return productoServicio.findAll();
    }

    @GetMapping("/tienda")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        } else {

            return "tienda";
        }
    }

    @GetMapping("/producto/{id}")
    public String showProduct(Model model, @PathVariable Long id){
        Producto result = productoServicio.findById(id);
        if (result != null){
            model.addAttribute("producto", result);
        }

        return "redirect:/tienda";
    }


}

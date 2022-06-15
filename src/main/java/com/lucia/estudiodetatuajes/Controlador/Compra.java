package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Servicio.ClienteServicio;
import com.lucia.estudiodetatuajes.Servicio.CompraServicio;
import com.lucia.estudiodetatuajes.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class Compra {

    @Autowired
    CompraServicio compraServicio;

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    HttpSession session;

    private Cliente cliente;

    @ModelAttribute("carrito")
    public List<Producto> productosCarrito(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        return (contenido == null) ? null : productoServicio.productosId(contenido);
    }

    @ModelAttribute("total_carrito")
    public Double totalCarrtio(){
        List<Producto> productosCarrito = productosCarrito();
        if (productosCarrito != null){
            return productosCarrito.stream()
                    .mapToDouble(p -> p.getPrecio())
                    .sum();
        }
        return 0.0;
    }

    @ModelAttribute("mis_compras")
    public List<com.lucia.estudiodetatuajes.Modelo.Compra> misCompras(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        cliente = (Cliente) session.getAttribute("usuario");
        return compraServicio.porCliente(cliente);
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model){
        return "app/compra/carrito";
    }

    @GetMapping("/carrito/add/{id}")
    public String addCarrito(Model model, @PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            contenido = new ArrayList<>();
        if (!contenido.contains(id))
            contenido.add(id);
        session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/eliminar/{id}")
    public String borrarDelCarrito(Model model, @PathVariable Long id){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/public/tienda";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito");
        else
            session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/finalizar")
    public String checkout(){
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/public/tienda";
        List<Producto> productos = productosCarrito();

        com.lucia.estudiodetatuajes.Modelo.Compra c = (com.lucia.estudiodetatuajes.Modelo.Compra) compraServicio.insertar(new com.lucia.estudiodetatuajes.Modelo.Compra(), session);

        productos.forEach(p -> compraServicio.addProductoCompra(p, c));
        session.removeAttribute("carrito");

        return "redirect:/app/compra/factura/"+c.getId();
    }

    @GetMapping("/compra/factura/{id}")
    public String factura(Model model, @PathVariable Long id){
        com.lucia.estudiodetatuajes.Modelo.Compra c = compraServicio.buscarPorId(id);
        List<Producto> productos = productoServicio.productosDeUnaCompra(c);
        model.addAttribute("productos", productos);
        model.addAttribute("compra", c);
        model.addAttribute("total_compra", productos.stream().mapToDouble(p -> p.getPrecio()).sum());
        return "app/compra/factura";
    }


    @GetMapping("/miscompras")
    public String verMisCompras(Model model){
        return "app/compra/listado";
    }






}
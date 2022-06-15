package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Modelo.Cita;
import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Compra;
import com.lucia.estudiodetatuajes.Modelo.Personal;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Repositorio.*;
import com.lucia.estudiodetatuajes.Servicio.*;
import com.lucia.estudiodetatuajes.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
public class admin {


    @Autowired
    PersonalRepo personalRepo;

    @Autowired
    PersonalServicio personalServicio;

    @Autowired
    CitaServicio citaServicio;

    @Autowired
    CitaRepo citaRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    ProductoRepo productoRepo;

    @Autowired
    StorageService storageService;

    @Autowired
    CompraRepo compraRepo;



    //sacar todas las citas existentes
    @GetMapping("/admin")
     public String obtenerCitas(Model model){
        List<Cita> cita = citaRepo.findAll();
        model.addAttribute("cita", cita);
        return "admin";
    }


    @GetMapping("/admin/personal")
    public String listarPersonal(Model model){
        List<Personal> personal = personalRepo.findAll();
        model.addAttribute("personals", personal);
        return "personal";
    }

    @GetMapping("/admin/clientes")
    public String listarClientes(Model model){
        List<Cliente> cliente = clienteRepo.findAll();
        model.addAttribute("cliente", cliente);
        return "clientes";
    }


    //Productos
    @GetMapping("/admin/productos")
    public String listarProductos(Model model){
        List<Producto> producto = productoServicio.findAll();
        model.addAttribute("productos", producto);
        return "productos";
    }

    //compras
    @GetMapping("/admin/compras")
    public String listarCompras(Model model){
        List<Compra> compra = compraRepo.findAll();
        model.addAttribute("compras", compra);
        return "compras";
    }

    //actualizar un producto
    @GetMapping("/admin/productos/actualizar/{id}")
    public String actualizarProductos(@PathVariable("id") Long id, Model model, Producto producto){
        productoRepo.findById(producto.getId());
        return "app/producto/form";
    }


    //eliminar un producto
    @GetMapping("/index2/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Producto producto, Long id){
        productoRepo.deleteById(producto.getId());
        return "productos";
    }

    //añadir un producto
    @GetMapping("/admin/producto/nuevo")
    public String agregarProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "app/producto/form";
    }

    @PostMapping("/admin/producto/guardar")
    public String nuevoProductoSubmit(@Valid Producto producto, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String imagen = storageService.store(file);
            producto.setImagen(MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "serveFile", imagen).build().toUriString());
        }
        productoServicio.insertar(producto);
        return "redirect:/admin/productos";
    }




//    //eliminar a un empleado
//    @GetMapping("/personal/eliminar/{id}")
//    public String eliminarPersonal(@PathVariable("id") Personal personal, Long id){
//        personalRepo.deleteById(personal.getId());
//        return "personal";
//    }
//
//
//    //añadir a un empleado
//    @GetMapping("/admin/personal/nuevo")
//    public String agregarPersonal(Model model){
//        model.addAttribute("personal", new Personal());
//        return "FormPersonal";
//    }
//
//    @PostMapping("/admin/personal/guardar")
//    public String nuevoPersonalSubmit(@Valid Personal personal) {
//        personalRepo.save(personal);
//        return "admin";
//    }





}

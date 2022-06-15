package com.lucia.estudiodetatuajes.Servicio;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Compra;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import com.lucia.estudiodetatuajes.Repositorio.ProductoRepo;
import com.lucia.estudiodetatuajes.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepo productoRepo;

    @Autowired
    StorageService storageService;

    public Producto insertar(Producto p){
        return productoRepo.save(p);
    }

    public void borrar(long id){
        productoRepo.deleteById(id);
    }

    public void borrar(Producto p){
        if (!p.getImagen().isEmpty())
            storageService.delete(p.getImagen());
        productoRepo.delete(p);
    }

    public Producto editar(Producto p){
        return productoRepo.save(p);
    }

    public Producto findById(long id){
        return productoRepo.findById(id).orElse(null);
    }


    public List<Producto> findAll(){
        return productoRepo.findAll();
    }

//    public List<Producto> ProductoDeUnPropietario(Cliente c){
//        return productoRepo.findByPropietario(c);
//    }

    public List<Producto> productosDeUnaCompra(Compra c){
        return productoRepo.findByCompra(c);
    }

    public List<Producto> ProductosSinVender(){
        return productoRepo.findByCompraIsNull();
    }


    public List<Producto> buscar(String query){
        return productoRepo.findByNombreContainsIgnoreCaseAndCompraIsNull(query);
    }


    public List<Producto> buscarMisProductos(String query, Cliente c){
     return productoRepo.findByNombreContainsIgnoreCaseAndCliente(query, c);
     }


    public List<Producto> productosId(List<Long> ids){
        return productoRepo.findAllById(ids);
    }

    public List<Producto> productoDeUnPropietario(Cliente c) {
     return productoRepo.findByCliente(c);
     }
}
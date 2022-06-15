package com.lucia.estudiodetatuajes.Repositorio;

import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Compra;
import com.lucia.estudiodetatuajes.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {

    List<Producto> findByCliente(Cliente cliente);

    List<Producto> findByCompra(Compra compra);

    List<Producto> findByCompraIsNull();

    List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);

    List<Producto> findByNombreContainsIgnoreCaseAndCliente(String nombre, Cliente cliente);

    List<Compra> findByCompra(Producto producto);

    @Query(value = "select *, pc.fecha_incorporacion from cancion c  join playlist_cancion pc on c.id = pc.cancion_id and pc.playlist_id =?1 order by pc.orden", nativeQuery = true)
    public List<Producto> productoCompra (int id);

    @Query(value = "select * from producto p  join producto_compra pc on p.id = pc.producto_id and pc.compra_id =?1", nativeQuery = true)
    public List<Producto> productosCompra (int id);



}

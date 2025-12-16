package com.itsqmet.controlador;

import com.itsqmet.modelo.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    private List<Producto> productos;

    public ProductoControlador(){
        productos = new ArrayList<>();
        productos.add(new Producto(1, "Laptop", "tecnologia", 25));
        productos.add(new Producto(2, "Mouse", "tecnologia", 15));
        productos.add(new Producto(3, "Teclado", "tecnologia", 50));
        productos.add(new Producto(4, "Padmouse", "tecnologia", 10));
    }

    //Listar productos
    @GetMapping
    public List<Producto> listarProductos(){
        return productos;
    }

    //Buscar productos por Id
    @GetMapping("/{id}")
    public Producto buscarProductoById(@PathVariable int id){
        for (Producto producto: productos){
            if (producto.getId()==id){
                return producto;
            }
        }
        return null;
    }

    //Guardar Producto
    @PostMapping("/registrarProducto")
    public Producto guardarProducto(@RequestBody Producto producto){
        producto.setId(productos.size()+1);
        productos.add(producto);
        return producto;
    }

    //Actualizar Producto
    @PutMapping("/editarProducto/{id}")
    public Producto actualizarProducto(@PathVariable int id,
                                       @RequestBody Producto producto){
        for(Producto productoExiste: productos){
            if(productoExiste.getId()==id){
                productoExiste.setNombre(producto.getNombre());
                productoExiste.setCategoria(producto.getCategoria());
                productoExiste.setStock(producto.getStock());
                return productoExiste;
            }
        }
        return null;
    }

    //Elmimiar Producto
    @DeleteMapping("/eliminarProducto/{id}")
    public void eliminarProducto(@PathVariable int id){
        for (Producto producto: productos){
            if(producto.getId()==id){
                productos.remove(producto);
                break;
            }
        }
    }




}

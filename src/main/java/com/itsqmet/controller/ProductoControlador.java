package com.itsqmet.controller;

import com.itsqmet.entity.Producto;
import com.itsqmet.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoService productoService;

    private List<Producto> productos;


    //Listar productos
    @GetMapping
    public List<Producto> listarProductos(){
        productos = productoService.mostrarProductos();
        return productos;
    }

    /*/Buscar productos por Id
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
    }*/




}

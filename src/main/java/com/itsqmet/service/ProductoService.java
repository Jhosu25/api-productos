package com.itsqmet.service;

import com.itsqmet.controller.ProductoControlador;
import com.itsqmet.entity.Producto;
import com.itsqmet.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //Leer
    public List<Producto> mostrarProductos(){
        return productoRepository.findAll();
    }

    //Buscar por id
    public Optional<Producto> buscarProductoById(Long id){
        return productoRepository.findById(id);
    }

    //Guardar
    public Producto guardarProducto(Producto producto){
        productoRepository.save(producto);
        return producto;
    }

    //Actualizar
    public Producto actualizarProducto(Long id, Producto producto){
        Producto productoExistente = buscarProductoById(id)
        .orElseThrow(() -> new RuntimeException("Producto no existe"));
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setStock(producto.getStock());
        return productoRepository.save(productoExistente);
    }

    //Eliminar
    public void eliminarProducto(Long id){
        Producto producto = buscarProductoById(id)
                //se lanza cuando no se encuentra el producto
                .orElseThrow(()-> new ResponseStatusException(
                        //constante de Spring que representa el codigo http 404
                        //404= recuerso no encontrado
                        HttpStatus.NOT_FOUND, "Producto no existe"
                ));
        productoRepository.delete(producto);
    }




}

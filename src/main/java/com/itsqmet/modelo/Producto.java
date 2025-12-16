package com.itsqmet.modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Producto {

    private int id;

    @Size(min = 5, max = 10)
    private String nombre;

    @Size(min = 5, max = 20)
    private String categoria;

    @Min(value = 5)
    @Max(value = 20)
    private int stock;

    public Producto() {
    }

    public Producto(int id, String nombre, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Producto(String nombre, String categoria, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

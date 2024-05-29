package com.co.gestionproductos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    private String nombre;
    private float precio;

    public Producto(Integer id_producto, String nombre, float precio) {
        super();
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, float precio) {
        super();
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
        super();
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}

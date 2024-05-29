package com.co.gestionproductos.services;

import com.co.gestionproductos.model.Producto;
import com.co.gestionproductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    /**
     * Metodo encargado de listar todos los productos de la BD
     */
    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    /**
     * Metodo encargado de consultar un producto en especifico segun su ID
     */
    public Producto obtenerProducto(Integer id) {
        return repositorio.findById(id).get();
    }

    /**
     * Metodo encargado de guardar un nuevo producto en BD
     */
    public void guardarProducto(Producto producto) {
        repositorio.save(producto);
    }

    /**
     * Metodo encargado de eliminar un producto de la BD segun su ID
     */
    public void eliminarProducto(Integer id) {
        repositorio.deleteById(id);
    }
}

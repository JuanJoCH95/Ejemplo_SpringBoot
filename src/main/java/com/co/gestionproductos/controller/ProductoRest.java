package com.co.gestionproductos.controller;

import com.co.gestionproductos.model.Producto;
import com.co.gestionproductos.model.Respuesta;
import com.co.gestionproductos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
public class ProductoRest {

    @Autowired
    private ProductoService servicios;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return servicios.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id) {
        Respuesta respuesta = new Respuesta();

        try {
            Producto producto = servicios.obtenerProducto(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception ex) {
            respuesta.setCodigo(404);
            respuesta.setDescripcion("El producto " + id + " no se encuentra registrado");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Respuesta> registrarProducto(@RequestBody Producto producto) {
        Respuesta respuesta = new Respuesta();

        try {
            servicios.guardarProducto(producto);
            respuesta.setCodigo(200);
            respuesta.setDescripcion("Producto registrado con exito");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        } catch (Exception ex) {
            respuesta.setCodigo(502);
            respuesta.setDescripcion("Ocurrio un error registrando el producto");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Respuesta> editarProducto(@RequestBody Producto producto) {
        Respuesta respuesta = new Respuesta();

        try {
            Producto productoExiste = servicios.obtenerProducto(producto.getId_producto());
            servicios.guardarProducto(producto);
            respuesta.setCodigo(200);
            respuesta.setDescripcion("Producto actualizado con exito");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        } catch (Exception ex) {
            respuesta.setCodigo(502);
            respuesta.setDescripcion("Ocurrio un error actualizando el producto");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Respuesta> eliminarProducto(@PathVariable Integer id) {
        Respuesta respuesta = new Respuesta();
        try {
            servicios.eliminarProducto(id);
            respuesta.setCodigo(200);
            respuesta.setDescripcion("Producto eliminado con exito");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        } catch (Exception ex) {
            respuesta.setCodigo(502);
            respuesta.setDescripcion("Ocurrio un error eliminando el producto");
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_GATEWAY);
        }
    }
}

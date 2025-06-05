package com.Micro.productos.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Micro.productos.Model.Producto;
import com.Micro.productos.Service.ProductoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Endpoint LISTAR TODOS LOS PRODUCTOS
    @GetMapping
    public ResponseEntity<?> getProducto(){
        return ResponseEntity.ok(productoService.findAll());
    }

    // Endpoint CREAR PRODUCTO
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        productoService.save(producto);
        return ResponseEntity.ok(producto);
    }

    // Endpoint Buscar PRODUCTO
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.findById(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getProductoPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(productoService.findByNombre(nombre));
}








}
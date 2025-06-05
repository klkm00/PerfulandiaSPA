package com.microservice_ventas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice_ventas.model.Venta;
import com.microservice_ventas.service.ServiceVenta;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final ServiceVenta ventaService;

    //endpoint para crear una venta
    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta ventaGuardada = ventaService.guardarVenta(venta);
        return new ResponseEntity<>(ventaGuardada, HttpStatus.CREATED);
    }
    //endpoint para obtener una venta por id
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //endpoint para obtener ventas por cliente
    
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Venta>> obtenerVentasPorCliente(@PathVariable Long clienteId) {
        List<Venta> ventas = ventaService.obtenerVentasPorClienteId(clienteId);
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }
}

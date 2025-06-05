package com.microservice_ventas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.microservice_ventas.Repository.RepositoryVenta.VentaRepository;
import com.microservice_ventas.model.DetalleVenta;
import com.microservice_ventas.model.Venta;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceVenta {





    private final VentaRepository ventaRepository;

    public Venta guardarVenta(Venta venta) {
        // Establece la relación entre cada detalle y la venta
        for (DetalleVenta detalle : venta.getDetalles()) {
            detalle.setVenta(venta);
        }

        // Guarda la venta junto con los detalles (gracias a CascadeType.ALL)
        return ventaRepository.save(venta);
    }

    // Método para obtener una venta por su ID
    public Optional<Venta> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public List<Venta> obtenerVentasPorClienteId(Long clienteId) {
        return ventaRepository.findByClienteId(clienteId);
    }



}
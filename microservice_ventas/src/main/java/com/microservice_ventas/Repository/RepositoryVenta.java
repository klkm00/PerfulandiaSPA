package com.microservice_ventas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice_ventas.model.DetalleVenta;
import com.microservice_ventas.model.Venta;

public class RepositoryVenta {
        public interface VentaRepository extends JpaRepository<Venta, Long> {

        List<Venta> findByClienteId(Long clienteId);}

    public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {}


}

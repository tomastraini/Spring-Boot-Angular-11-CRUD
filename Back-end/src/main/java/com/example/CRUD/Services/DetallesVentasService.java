package com.example.CRUD.Services;

import com.example.CRUD.DTOs.DetallesVentasDTO;
import com.example.CRUD.Models.DetalleVenta;
import com.example.CRUD.Models.Productos;
import com.example.CRUD.Repositories.DetalleVentaRepo;
import com.example.CRUD.Repositories.ProductosRepo;
import com.example.CRUD.Services.Interfaces.IDetallesVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallesVentasService implements IDetallesVentasService
{
    @Autowired
    public DetalleVentaRepo repo;
    @Autowired
    public ProductosRepo productosRepo;

    @Override
    public List<DetallesVentasDTO> getDetalles()
    {
        List<DetallesVentasDTO> response = new ArrayList<DetallesVentasDTO>();
        List<DetalleVenta> detalleVentas = repo.findAll();
        List<Productos> prod = productosRepo.findAll();

        detalleVentas.forEach(d -> {
            response.add(new DetallesVentasDTO(
                    d.id_detalle_venta,
                    d.id_producto,
                    d.id_venta,
                    prod.stream().filter(p -> p.id_producto == d.id_producto).findFirst().get().descripcion,
                    d.importe,
                    d.cantidad,
                    d.importe_r
            ));
        });

        return response;
    }

    @Override
    public DetalleVenta insertDetalles(DetalleVenta det)
    {
        if (det == null) { return null; }
        det.id_detalle_venta = 0;
        repo.save(det);
        return det;
    }

    @Override
    public DetalleVenta deleteDetalles(Long id)
    {
        if (id == null || id == 0){ return null; }
        DetalleVenta detalleVentas = repo.findAll()
                .stream().filter(detalleVenta -> detalleVenta.id_detalle_venta == id).findFirst().get();
        if (detalleVentas == null) { return null; }
        repo.delete(detalleVentas);
        return detalleVentas;
    }
}

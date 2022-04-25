package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.DTOs.DetallesVentasDTO;
import com.example.CRUD.Models.DetalleVenta;

import java.util.List;

public interface IDetallesVentasService
{
    public List<DetallesVentasDTO> getDetalles();
    public DetalleVenta insertDetalles(DetalleVenta det);
    public DetalleVenta deleteDetalles(Long id);
}

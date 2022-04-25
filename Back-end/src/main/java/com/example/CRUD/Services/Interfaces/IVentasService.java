package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.DTOs.VentasDTO;
import com.example.CRUD.Models.Ventas;

import java.util.List;

public interface IVentasService
{
    public List<VentasDTO> getVentas();
    public Ventas insertVentas(Ventas ventas);
    public Ventas modifyVentas(Ventas ventas);
    public Ventas deleteVentas(Long id);
}

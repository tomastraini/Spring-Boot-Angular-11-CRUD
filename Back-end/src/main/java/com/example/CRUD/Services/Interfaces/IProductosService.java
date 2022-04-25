package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.DTOs.ProductosDTO;
import com.example.CRUD.Models.Productos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductosService
{
    public List<ProductosDTO> getProductos();
    public Productos insertProductos(Productos productos);
    public Productos modifyProductos(Productos productos);
    public Productos deleteProductos(Long id);
}

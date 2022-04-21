package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.Proveedores;

import java.util.List;

public interface IProveedoresService {
    public List<Proveedores> getProveedores();
    public Proveedores insertProveedores(Proveedores prov);
    public Proveedores modifyProveedores(Proveedores prov);
    public Proveedores deleteProveedores(long id);
}

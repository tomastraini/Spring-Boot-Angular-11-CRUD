package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.Provincias;

import java.util.List;

public interface IProvinciasService {
    public List<Provincias> getProvincias();
    public Provincias insertProvincias(Provincias prov);
    public Provincias modifyProvincias(Provincias prov);
    public Provincias removeProvincias(long id);
}

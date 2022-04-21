package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.Usuarios;

import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> getUsuarios();
    public Usuarios insertUsuarios(Usuarios users);
}

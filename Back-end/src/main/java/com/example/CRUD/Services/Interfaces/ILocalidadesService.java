package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.DTOs.LocalidadesDTO;
import com.example.CRUD.Models.Localidades;
import com.sun.istack.NotNull;

import java.util.List;

public interface ILocalidadesService {
    public List<LocalidadesDTO> getLocalidades();
    public Localidades postLocalidades(Localidades loc);
    public Localidades modifyLocalidad(Localidades loc);
    public Localidades deleteLocalidad(@NotNull long id);
}

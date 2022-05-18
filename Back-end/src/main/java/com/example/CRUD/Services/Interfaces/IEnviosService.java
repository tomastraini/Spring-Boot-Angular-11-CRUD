package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.DTOs.EnviosDTO;
import com.example.CRUD.Models.Envios;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEnviosService
{
    public List<EnviosDTO> getEnvios();
    public Envios insertEnvios(@RequestBody Envios envios);
    public Envios updateEnvios(@RequestBody Envios envios);
    public void deleteEnvios(Long id);
}

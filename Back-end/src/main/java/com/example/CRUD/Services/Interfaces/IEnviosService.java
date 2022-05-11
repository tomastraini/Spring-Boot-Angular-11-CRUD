package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.Envios;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEnviosService
{
    public List<Envios> getEnvios();
    public Envios insertEnvios(@RequestBody Envios envios);
    public Envios updateEnvios(@RequestBody Envios envios);
    public void deleteEnvios(int id);
}

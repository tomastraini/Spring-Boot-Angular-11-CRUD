package com.example.CRUD.Services;

import com.example.CRUD.Models.Envios;
import com.example.CRUD.Repositories.ClientesRepo;
import com.example.CRUD.Repositories.EnviosRepo;
import com.example.CRUD.Services.Interfaces.IEnviosService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class EnviosService implements IEnviosService
{
    public EnviosRepo repo;
    public ClientesRepo clientesRepo;

    public EnviosService(EnviosRepo repo, ClientesRepo clientesRepo)
    {
        this.repo = repo;
        this.clientesRepo = clientesRepo;
    }

    @Override
    public List<Envios> getEnvios()
    {
        return repo.findAll();
    }

    @Override
    public Envios insertEnvios(Envios envios)
    {
        if(envios.id_cliente == 0){ return null; }
        if(envios.telefono == null){ return null; }
        if(envios.costo == null || envios.costo == 0){ return null; }
        if(envios.direccion == null){ return null; }

        if(!clientesRepo.findAll().stream().anyMatch(x -> x.id_cliente == envios.id_cliente)){ return null; }

        int lastId = repo.findAll().size();
        envios.setId_envio(lastId + 1);

        repo.save(envios);
        return envios;
    }

    @Override
    public Envios updateEnvios(Envios envios)
    {
        if(envios.id_envio == 0){ return null; }
        if(envios.id_cliente == 0){ return null; }
        if(envios.telefono == null){ return null; }
        if(envios.costo == null || envios.costo == 0){ return null; }
        if(envios.direccion == null){ return null; }
        if(envios.fecha == null){ return null; }

        if(!clientesRepo.findAll().stream().anyMatch(x -> x.id_cliente == envios.id_cliente)){ return null; }

        if(!repo.findAll().stream().anyMatch(x -> x.id_envio == envios.id_envio)){ return null; }

        repo.save(envios);
        return envios;
    }

    @Override
    public void deleteEnvios(int id)
    {
        repo.findAll().stream().filter(x -> x.id_envio == id).forEach(x -> repo.delete(x));
    }
}

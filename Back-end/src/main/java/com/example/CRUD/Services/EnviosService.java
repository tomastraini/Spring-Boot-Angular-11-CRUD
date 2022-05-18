package com.example.CRUD.Services;

import com.example.CRUD.DTOs.EnviosDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.Envios;
import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Repositories.ClientesRepo;
import com.example.CRUD.Repositories.EnviosRepo;
import com.example.CRUD.Repositories.LocalidadesRepo;
import com.example.CRUD.Services.Interfaces.IEnviosService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EnviosService implements IEnviosService
{
    public EnviosRepo repo;
    public ClientesRepo clientesRepo;
    public LocalidadesRepo localidadesRepo;
    public EnviosService(EnviosRepo repo, ClientesRepo clientesRepo, LocalidadesRepo localidadesRepo)
    {
        this.repo = repo;
        this.clientesRepo = clientesRepo;
        this.localidadesRepo = localidadesRepo;
    }

    @Override
    public List<EnviosDTO> getEnvios()
    {
        List<Envios> envios = repo.findAll();
        List<Clientes> clientes = clientesRepo.findAll();
        List<Localidades> loc = localidadesRepo.findAll();
        List<EnviosDTO> response = new ArrayList<EnviosDTO>();
        envios.forEach(envio -> {
            response.add(new EnviosDTO(envio.getId_envio(), 
            envio.get_id(), 
            envio.getId_cliente(), 
            clientes.stream()
                .filter(cliente -> cliente.getId() == envio.getId_cliente()).findFirst().get().getrazon_social(),
            loc.stream()
                .filter(localidad -> localidad.getCp() == clientes.stream()
                    .filter(cliente -> cliente.getId() == envio.getId_cliente()).findFirst().get().getCp()).findFirst().get().getLocalidad(),
                    envio.getTelefono(), envio.getFecha(), envio.getDireccion(), envio.getCosto()));
        });

        return response;
    }

    @Override
    public Envios insertEnvios(Envios envios)
    {
        if(envios.id_cliente == 0){ return null; }
        if(envios.telefono == null){ return null; }
        if(envios.costo == null || envios.costo == 0){ return null; }
        if(envios.direccion == null){ return null; }

        if(!clientesRepo.findAll().stream().anyMatch(x -> x.id_cliente == envios.id_cliente)){ return null; }

        int id_envio = repo.findAll().stream().mapToInt(x -> x.id_envio).max().orElse(0) + 1;
        envios.setId_envio(id_envio);

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

        Envios envioToSave = repo.findAll()
                .stream().filter(x -> x.id_envio == envios.id_envio)
                .findFirst().get();
        envioToSave.costo = envios.costo;
        envioToSave.id_cliente = envios.id_cliente;
        envioToSave.telefono = envios.telefono;
        envioToSave.direccion = envios.direccion;
        envioToSave.fecha = envios.fecha;

        repo.save(envioToSave);
        return envios;
    }

    @Override
    public void deleteEnvios(Long id)
    {
        repo.findAll().stream().filter(x -> x.id_envio == id).forEach(x -> repo.delete(x));
    }
}

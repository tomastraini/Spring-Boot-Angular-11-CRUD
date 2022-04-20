package com.example.CRUD.Services;

import com.example.CRUD.DTOs.ClientesDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Repositories.ClientesRepo;
import com.example.CRUD.Repositories.LocalidadesRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientesService {
    @Autowired
    public ClientesRepo clientesRepo;
    @Autowired
    public LocalidadesRepo localidadesRepo;

    public ClientesService() {
    }
    public List<ClientesDTO> getClientes()
    {
        List<Clientes> cli = clientesRepo.findAll();
        List<Localidades> loc = localidadesRepo.findAll();
        List<ClientesDTO> response = new ArrayList<ClientesDTO>();
        cli.forEach(clit -> {
            response.add(new ClientesDTO(clit.id_cliente, clit.razon_social,
                    clit.telefono, loc.stream().filter(x -> x.cp == clit.cp).findFirst().get().localidad,
                    clit.cp
            ));
        });
        return response;
    }

    public ClientesDTO getCliente(@NotNull long id)
    {
        if(id == 0) { return null; }
        List<Clientes> query = clientesRepo.findAll();
        Clientes clit = query.stream().filter(x -> x.id_cliente == id)
                .findFirst().get();

        if(clit == null) { return null; }
        List<Localidades> loc = localidadesRepo.findAll();
        ClientesDTO response = new ClientesDTO(clit.id_cliente, clit.razon_social,
                clit.telefono, loc.stream().filter(x -> x.cp == clit.cp).findFirst().get().localidad,
                clit.cp);
        return response;
    }

    public Clientes insertClientes(Clientes cli)
    {
        clientesRepo.save(cli);
        return cli;
    }
    public Clientes modifyClientes(Clientes cli)
    {
        if(cli.id_cliente == 0){ return null; }
        Clientes clitoModify = clientesRepo.findAll()
                .stream().filter(x -> x.id_cliente == cli.id_cliente).findFirst().get();
        clitoModify = cli;
        clientesRepo.save(clitoModify);
        return cli;
    }
    public Clientes deleteCliente(@NotNull long id)
    {
        if(id == 0) { return null; }
        Clientes clitoDelete = clientesRepo.findAll()
                .stream().filter(x -> x.id_cliente == id).findFirst().get();

        if(clitoDelete == null) { return null; }

        clientesRepo.delete(clitoDelete);

        return clitoDelete;
    }
}

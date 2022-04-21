package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.DTOs.ClientesDTO;
import com.example.CRUD.Models.Clientes;
import com.sun.istack.NotNull;

import java.util.List;

public interface IClientesService {
    public List<ClientesDTO> getClientes();
    public ClientesDTO getCliente(@NotNull long id);
    public Clientes insertClientes(Clientes cli);
    public Clientes modifyClientes(Clientes cli);
    public Clientes deleteCliente(@NotNull long id);
}

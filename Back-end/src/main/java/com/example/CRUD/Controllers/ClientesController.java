package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.ClientesDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Services.ClientesService;
import com.example.CRUD.Services.Interfaces.IClientesService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientesController {
    public IClientesService srv;

    public ClientesController(IClientesService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> getClientes()
    {
        return new ResponseEntity<>(srv.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesDTO> getCliente(@PathVariable @NotNull Long id)
    {
        try
        {
            if(id == null){ return null; }
            return new ResponseEntity<>(srv.getCliente(id), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Clientes> insertCliente(@RequestBody Clientes cli)
    {
        return new ResponseEntity<>(srv.insertClientes(cli), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Clientes> modifyCliente(@RequestBody Clientes cli)
    {
        try
        {
            return new ResponseEntity<>(srv.modifyClientes(cli), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Clientes> deleteCliente(@PathVariable @NotNull Long id)
    {
        try
        {
            return new ResponseEntity<>(srv.deleteCliente(id), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

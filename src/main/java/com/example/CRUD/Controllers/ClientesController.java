package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.ClientesDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Services.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ClientesController {
    public ClientesService srv;

    public ClientesController(ClientesService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> getHelloWorld()
    {
        return new ResponseEntity<>(srv.getClientes(), HttpStatus.OK);
    };

}

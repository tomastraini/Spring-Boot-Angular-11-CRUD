package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.EnviosDTO;
import com.example.CRUD.Models.Envios;
import com.example.CRUD.Services.Interfaces.IEnviosService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Envios")
@CrossOrigin()
public class EnviosController
{
    public IEnviosService srv;

    public EnviosController(IEnviosService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<EnviosDTO>> getEnvios()
    {
        return new ResponseEntity<>(srv.getEnvios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Envios> insertEnvios(@RequestBody Envios envios)
    {
        return new ResponseEntity<>(srv.insertEnvios(envios), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Envios> updateEnvios(@RequestBody Envios envios)
    {
        return new ResponseEntity<>(srv.updateEnvios(envios), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvios(@PathVariable @NotNull Long id)
    {
        srv.deleteEnvios(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

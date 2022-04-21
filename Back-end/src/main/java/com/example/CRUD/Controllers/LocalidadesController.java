package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.LocalidadesDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Services.ClientesService;
import com.example.CRUD.Services.Interfaces.ILocalidadesService;
import com.example.CRUD.Services.LocalidadesService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Localidades")
@CrossOrigin(origins = "http://localhost:4200")
public class LocalidadesController {
    public ILocalidadesService srv;

    public LocalidadesController(ILocalidadesService srv)
    {
        this.srv = srv;
    }
    @GetMapping
    public ResponseEntity<List<LocalidadesDTO>> getLocalidades()
    {
        return new ResponseEntity<>(srv.getLocalidades(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Localidades> postLocalidades(@RequestBody Localidades loc)
    {
        return new ResponseEntity<>(srv.postLocalidades(loc), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Localidades> modifyLocalidad(@RequestBody Localidades loc)
    {
        return new ResponseEntity<>(srv.modifyLocalidad(loc), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Localidades> deleteLocalidad(@PathVariable @NotNull Long id)
    {
        try
        {
            return new ResponseEntity<>(srv.deleteLocalidad(id), HttpStatus.OK);

        }catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

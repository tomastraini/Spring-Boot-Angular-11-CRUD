package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.Provincias;
import com.example.CRUD.Services.Interfaces.IProvinciasService;
import com.example.CRUD.Services.LocalidadesService;
import com.example.CRUD.Services.ProvinciasService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Provincias")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciasController {
    public IProvinciasService srv;

    public ProvinciasController(IProvinciasService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<Provincias>> getProvincias()
    {
        return new ResponseEntity<>(srv.getProvincias(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Provincias> insertProvincias(@RequestBody Provincias prov)
    {
        return new ResponseEntity<>(srv.insertProvincias(prov), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Provincias> modifyProvincias(@RequestBody Provincias prov)
    {
        return new ResponseEntity<>(srv.modifyProvincias(prov), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Provincias> removeProvincias(@PathVariable @NotNull Long id)
    {
        return new ResponseEntity<>(srv.removeProvincias(id), HttpStatus.OK);
    }
}

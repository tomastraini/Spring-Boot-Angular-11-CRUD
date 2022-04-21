package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Proveedores;
import com.example.CRUD.Services.Interfaces.IProveedoresService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Proveedores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedoresController {
    public IProveedoresService srv;

    public ProveedoresController(IProveedoresService srv) {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<Proveedores>> getProveedores()
    {
        return new ResponseEntity<>(srv.getProveedores(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proveedores> insertProveedores(@RequestBody Proveedores prov)
    {
        return new ResponseEntity<>(srv.insertProveedores(prov), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Proveedores> modifyProveedores(@RequestBody Proveedores prov)
    {
        return new ResponseEntity<>(srv.modifyProveedores(prov), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Proveedores> deleteProveedores(@PathVariable @NotNull Long id)
    {
        return new ResponseEntity<>(srv.deleteProveedores(id), HttpStatus.OK);
    }
}

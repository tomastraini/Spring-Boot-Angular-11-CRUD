package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.VentasDTO;
import com.example.CRUD.Models.Ventas;
import com.example.CRUD.Services.Interfaces.IVentasService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ventas")
@CrossOrigin()
public class VentasController {
    public IVentasService srv;

    public VentasController(IVentasService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<VentasDTO>> getVentas()
    {
        return new ResponseEntity<>(srv.getVentas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ventas> insertVentas(@RequestBody Ventas ventas)
    {
        return new ResponseEntity<>(srv.insertVentas(ventas), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Ventas> modifyVentas(@RequestBody Ventas ventas)
    {
        return new ResponseEntity<>(srv.modifyVentas(ventas), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ventas> deleteVentas(@PathVariable @NotNull Long id)
    {
        return new ResponseEntity<>(srv.deleteVentas(id), HttpStatus.OK);
    }
}

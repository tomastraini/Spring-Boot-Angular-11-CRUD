package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.DetallesVentasDTO;
import com.example.CRUD.Models.DetalleVenta;
import com.example.CRUD.Services.Interfaces.IDetallesVentasService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DetallesVentas")
@CrossOrigin()
public class DetallesVentasController
{
    public IDetallesVentasService srv;

    public DetallesVentasController(IDetallesVentasService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<DetallesVentasDTO>> getDetalles()
    {
        return new ResponseEntity<>(srv.getDetalles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> insertDetalles(@RequestBody DetalleVenta det)
    {
        return new ResponseEntity<>(srv.insertDetalles(det), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DetalleVenta> deleteDetalles(@PathVariable @NotNull Long det)
    {
        return new ResponseEntity<>(srv.deleteDetalles(det), HttpStatus.OK);
    }
}

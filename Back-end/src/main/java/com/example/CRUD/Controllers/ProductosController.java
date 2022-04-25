package com.example.CRUD.Controllers;

import com.example.CRUD.DTOs.ProductosDTO;
import com.example.CRUD.Models.Productos;
import com.example.CRUD.Services.Interfaces.IProductosService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productos")
@CrossOrigin()
public class ProductosController {
    public IProductosService srv;

    public ProductosController(IProductosService srv) {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<ProductosDTO>> getProductos()
    {
        return new ResponseEntity<>(srv.getProductos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Productos> insertProductos(@RequestBody Productos productos)
    {
        return new ResponseEntity<>(srv.insertProductos(productos), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Productos> modifyProductos(@RequestBody Productos productos)
    {
        return new ResponseEntity<>(srv.modifyProductos(productos), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Productos> deleteProductos(@PathVariable @NotNull Long id)
    {
        return new ResponseEntity<>(srv.deleteProductos(id), HttpStatus.OK);
    }
}

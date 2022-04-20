package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Provincias;
import com.example.CRUD.Services.LocalidadesService;
import com.example.CRUD.Services.ProvinciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Provincias")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciasController {
    public ProvinciasService srv;

    public ProvinciasController(ProvinciasService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<Provincias>> getProvincias()
    {
        return new ResponseEntity<>(srv.getProvincias(), HttpStatus.OK);
    }
}

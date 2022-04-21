package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Repositories.UsuariosRepo;
import com.example.CRUD.Services.Interfaces.IUsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    public IUsuariosService srv;
    public UserController(IUsuariosService srv) {
        this.srv = srv;
    }
    @GetMapping
    public ResponseEntity<List<Usuarios>> getUsuarios()
    {
        return new ResponseEntity<>(srv.getUsuarios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuarios> insertUsuarios(@RequestBody Usuarios users)
    {
        return new ResponseEntity<>(srv.insertUsuarios(users), HttpStatus.OK);
    }
}
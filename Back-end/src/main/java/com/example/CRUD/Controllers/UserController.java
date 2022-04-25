package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Repositories.UsuariosRepo;
import com.example.CRUD.Services.Interfaces.IUsuariosService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin()
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

    @GetMapping("/{username}")
    public ResponseEntity<Usuarios> getUsuarios(@PathVariable @NotNull String username)
    {
        if(username == null) { return null; }
        try
        {
            return new ResponseEntity<>(srv.getUsuario(username), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuarios> insertUsuarios(@RequestBody Usuarios users)
    {
        return new ResponseEntity<>(srv.insertUsuarios(users), HttpStatus.OK);
    }
}
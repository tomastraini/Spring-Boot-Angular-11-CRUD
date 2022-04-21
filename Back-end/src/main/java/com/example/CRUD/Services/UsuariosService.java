package com.example.CRUD.Services;

import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Repositories.UsuariosRepo;
import com.example.CRUD.Services.Interfaces.IUsuariosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService implements IUsuariosService {
    public UsuariosRepo repo;

    public UsuariosService(UsuariosRepo repo) {
        this.repo = repo;
    }


    @Override
    public List<Usuarios> getUsuarios() {
        return repo.findAll();
    }

    @Override
    public Usuarios insertUsuarios(Usuarios users) {
        users.permiso = "user";
        repo.save(users);
        return users;
    }
}

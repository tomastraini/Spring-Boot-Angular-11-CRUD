package com.example.CRUD.Services;

import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Repositories.UsuariosRepo;
import com.example.CRUD.Services.Interfaces.IUsuariosService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService implements IUsuariosService {
    public UsuariosRepo repo;

    public UsuariosService(UsuariosRepo repo) {
        this.repo = repo;
    }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    @Override
    public List<Usuarios> getUsuarios() {
        return repo.findAll();
    }

    @Override
    public Usuarios getUsuario(String username) {
        List<Usuarios> usuariosList = repo.findAll();
        Usuarios us =  usuariosList.stream().filter(x -> x.usuario.contains(username)).findFirst().get();
        if(us == null) { return null; }
        return us;
    }

    @Override
    public Usuarios insertUsuarios(Usuarios users) {
        users.permiso = "user";
        users.pass = hash(users.pass);
        repo.save(users);
        return users;
    }
}

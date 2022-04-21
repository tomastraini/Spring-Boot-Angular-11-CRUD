package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepo extends JpaRepository<Usuarios, Long> {
}

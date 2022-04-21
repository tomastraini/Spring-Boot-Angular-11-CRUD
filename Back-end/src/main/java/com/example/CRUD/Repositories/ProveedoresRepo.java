package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedoresRepo extends JpaRepository<Proveedores, Long> {
}

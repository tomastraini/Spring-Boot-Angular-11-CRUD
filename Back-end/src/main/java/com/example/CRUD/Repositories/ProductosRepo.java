package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepo extends JpaRepository<Productos,Long> {
}

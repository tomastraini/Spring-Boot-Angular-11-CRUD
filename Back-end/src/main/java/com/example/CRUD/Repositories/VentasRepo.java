package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepo extends JpaRepository<Ventas, Long> {
}

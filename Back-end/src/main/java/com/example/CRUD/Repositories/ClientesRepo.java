package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepo extends JpaRepository<Clientes, Long> {
}

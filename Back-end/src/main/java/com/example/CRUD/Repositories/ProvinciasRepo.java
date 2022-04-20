package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Models.Provincias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciasRepo extends JpaRepository<Provincias, Long> {
}

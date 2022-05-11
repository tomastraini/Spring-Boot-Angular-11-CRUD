package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Envios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnviosRepo extends MongoRepository<Envios, String> {
}

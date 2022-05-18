package com.example.CRUD.Repositories;

import com.example.CRUD.Models.VisitIPs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitIPsRepo extends MongoRepository<VisitIPs, String> {
}

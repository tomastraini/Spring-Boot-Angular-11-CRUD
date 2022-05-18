package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Whitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface WhitelistRepo extends MongoRepository<Whitelist, String>
{
}

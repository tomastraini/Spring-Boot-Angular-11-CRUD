package com.example.CRUD.Services;

import com.example.CRUD.Models.Provincias;
import com.example.CRUD.Repositories.ProvinciasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciasService {
    @Autowired
    public ProvinciasRepo repo;

    public ProvinciasService(ProvinciasRepo repo) {
        this.repo = repo;
    }

    public List<Provincias> getProvincias()
    {
        return repo.findAll();
    }
}

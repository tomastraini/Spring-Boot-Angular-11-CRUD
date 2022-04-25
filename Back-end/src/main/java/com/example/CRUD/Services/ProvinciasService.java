package com.example.CRUD.Services;

import com.example.CRUD.Models.Provincias;
import com.example.CRUD.Repositories.ProvinciasRepo;
import com.example.CRUD.Services.Interfaces.IProvinciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciasService implements IProvinciasService {
    @Autowired
    public ProvinciasRepo repo;

    public ProvinciasService(ProvinciasRepo repo) {
        this.repo = repo;
    }

    public List<Provincias> getProvincias()
    {
        return repo.findAll();
    }

    public Provincias insertProvincias(Provincias prov)
    {
        repo.save(prov);
        return prov;
    }

    public Provincias modifyProvincias(Provincias prov)
    {
        Provincias provToModify = repo.findAll()
                .stream().filter(x -> x.id_provincia == prov.id_provincia).findFirst().get();
        if(provToModify == null) { return  null; }
        provToModify = prov;
        repo.save(provToModify);
        return prov;
    }

    public Provincias removeProvincias(long id)
    {
        Provincias prov = repo.findAll()
                .stream().filter(x -> x.id_provincia == id)
                .findFirst().get();
        repo.delete(prov);
        return prov;
    }
}

package com.example.CRUD.Services;

import com.example.CRUD.DTOs.LocalidadesDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Models.Provincias;
import com.example.CRUD.Repositories.LocalidadesRepo;
import com.example.CRUD.Repositories.ProvinciasRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalidadesService {
    @Autowired
    public LocalidadesRepo localidadesRepo;
    @Autowired
    public ProvinciasRepo provinciasRepo;

    public List<LocalidadesDTO> getLocalidades()
    {
        List<Localidades> loc = localidadesRepo.findAll();

        List<Provincias> prov = provinciasRepo.findAll();

        List<LocalidadesDTO> response = new ArrayList<LocalidadesDTO>();

        loc.forEach(r ->{
            response.add(new LocalidadesDTO(
                    r.cp,
                    prov.stream().filter(p -> p.id_provincia == r.id_provincia).findFirst().get().provincia,
                    r.localidad,
                    r.id_provincia
            ));
        });

        return response;
    }

    public Localidades postLocalidades(Localidades loc)
    {
        localidadesRepo.save(loc);
        return loc;
    }


    public Localidades modifyLocalidad(Localidades loc)
    {
        if(loc.cp == 0){ return null; }
        Localidades loctoModify = localidadesRepo.findAll()
                .stream().filter(x -> x.cp == loc.cp).findFirst().get();

        loctoModify = loc;
        localidadesRepo.save(loctoModify);
        return loc;
    }

    public Localidades deleteLocalidad(@NotNull long id)
    {
        if(id == 0) { return null; }
        Localidades loctoDelete = localidadesRepo.findAll()
                .stream().filter(x -> x.cp == id).findFirst().get();

        if(loctoDelete == null) { return null; }

        localidadesRepo.delete(loctoDelete);

        return loctoDelete;
    }
}

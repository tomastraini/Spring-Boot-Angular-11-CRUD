package com.example.CRUD.Services;

import com.example.CRUD.DTOs.ClientesDTO;
import com.example.CRUD.DTOs.ProveedoresDTO;
import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Models.Proveedores;
import com.example.CRUD.Models.Provincias;
import com.example.CRUD.Repositories.LocalidadesRepo;
import com.example.CRUD.Repositories.ProveedoresRepo;
import com.example.CRUD.Services.Interfaces.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedoresService implements IProveedoresService {
    @Autowired
    public ProveedoresRepo repo;

    @Autowired
    public LocalidadesRepo localidadesRepo;

    public ProveedoresService() {
    }

    @Override
    public List<ProveedoresDTO> getProveedores() {
        List<Proveedores> prov = repo.findAll();
        List<Localidades> loc = localidadesRepo.findAll();
        List<ProveedoresDTO> response = new ArrayList<ProveedoresDTO>();
        prov.forEach(p -> {
            response.add(new ProveedoresDTO(p.id_proveedor, p.razon_social_proveedor, p.telefono_proveedor,
                    loc.stream().filter(x -> x.cp == p.cp).findFirst().get().localidad,
                    loc.stream().filter(x -> x.cp == p.cp).findFirst().get().cp));
        });

        return response;
    }

    @Override
    public Proveedores insertProveedores(Proveedores prov)
    {
        repo.save(prov);
        return prov;
    }

    @Override
    public Proveedores modifyProveedores(Proveedores prov) {

        Proveedores provToModify = repo.findAll()
                .stream().filter(x -> x.id_proveedor == prov.id_proveedor).findFirst().get();
        if(provToModify == null) { return  null; }
        provToModify = prov;
        repo.save(provToModify);
        return prov;
    }

    @Override
    public Proveedores deleteProveedores(long id) {
        Proveedores prov = repo.findAll()
                .stream().filter(x -> x.id_proveedor == id)
                .findFirst().get();
        repo.delete(prov);
        return prov;
    }
}

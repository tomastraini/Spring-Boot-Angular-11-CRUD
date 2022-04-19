package com.example.CRUD.Services;

import com.example.CRUD.DTOs.ClientesDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.Localidades;
import com.example.CRUD.Repositories.ClientesRepo;
import com.example.CRUD.Repositories.LocalidadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@EnableJpaRepositories(basePackages={"example.CRUD.Repositories.ClientesRepository"})
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses=Clientes.class)
@ComponentScan(basePackages={"example.CRUD.Repositories.ClientesRepository"})
public class ClientesService {
    @Autowired
    public ClientesRepo clientesRepo;
    @Autowired
    public LocalidadesRepo localidadesRepo;

    public ClientesService() {
    }

    public List<ClientesDTO> getClientes()
    {
        List<Clientes> cli = clientesRepo.findAll();
        List<Localidades> loc = localidadesRepo.findAll();
        List<ClientesDTO> response = new ArrayList<ClientesDTO>();
        cli.forEach(clit -> {
            response.add(new ClientesDTO(clit.id_cliente, clit.razon_social,
                    clit.telefono, loc.stream().filter(x -> x.cp == clit.cp).findFirst().get().localidad
            ));
        });
        return response;
    }
}

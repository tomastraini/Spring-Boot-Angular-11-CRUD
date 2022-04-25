package com.example.CRUD.Services;

import com.example.CRUD.DTOs.VentasDTO;
import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.FormasDePago;
import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Models.Ventas;
import com.example.CRUD.Repositories.ClientesRepo;
import com.example.CRUD.Repositories.FormasDePagoRepo;
import com.example.CRUD.Repositories.UsuariosRepo;
import com.example.CRUD.Repositories.VentasRepo;
import com.example.CRUD.Services.Interfaces.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VentasService implements IVentasService
{
    @Autowired
    public VentasRepo repo;

    @Autowired
    public ClientesRepo clientesRepo;

    @Autowired
    public FormasDePagoRepo formasDePagoRepo;
    @Autowired
    public UsuariosRepo usersRepo;

    public VentasService(VentasRepo repo)
    {
        this.repo = repo;
    }

    @Override
    public List<VentasDTO> getVentas() {
        List<VentasDTO> response = new ArrayList<VentasDTO>();
        List<Ventas> ventas = repo.findAll();
        List<Clientes> clientes = clientesRepo.findAll();
        List<FormasDePago> formasPagos = formasDePagoRepo.findAll();
        List<Usuarios> users = usersRepo.findAll();

        ventas.forEach(v -> {
            response.add(new VentasDTO(
                    v.id_venta,
                    v.id_cliente,
                    clientes.stream().filter(x -> x.id_cliente == v.id_cliente).findFirst().get().razon_social,
                    v.id_forma_pago,
                    formasPagos.stream().filter(x -> x.id_forma_pago == v.id_forma_pago).findFirst().get().forma_pago,
                    v.id_usuario,
                    users.stream().filter(x -> x.id_usuario == v.id_usuario).findFirst().get().usuario,
                    v.importe,
                    v.fecha
            ));
        });
        return response;
    }

    @Override
    public Ventas insertVentas(Ventas ventas) {
        if(ventas == null) { return null; }
        Calendar cal = Calendar.getInstance();
        ventas.fecha = cal.getTime();
        repo.save(ventas);
        return ventas;
    }

    @Override
    public Ventas modifyVentas(Ventas ventas) {
        if(ventas == null || ventas.id_venta == 0) { return null; }
        Ventas query = repo.findAll().stream().filter(x -> x.id_venta == ventas.id_venta).findFirst().get();
        if(query == null) { return null; }
        Calendar cal = Calendar.getInstance();

        query.fecha = cal.getTime();
        query = ventas;
        repo.save(query);
        return ventas;
    }

    @Override
    public Ventas deleteVentas(Long id) {
        if(id == null || id == 0) { return null; }
        Ventas query = repo.findAll().stream().filter(x -> x.id_venta == id).findFirst().get();
        if (query == null) { return null; }
        repo.delete(query);

        return query;
    }
}

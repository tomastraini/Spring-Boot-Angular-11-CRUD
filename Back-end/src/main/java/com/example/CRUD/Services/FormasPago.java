package com.example.CRUD.Services;

import com.example.CRUD.Models.Clientes;
import com.example.CRUD.Models.FormasDePago;
import com.example.CRUD.Models.Proveedores;
import com.example.CRUD.Repositories.FormasDePagoRepo;
import com.example.CRUD.Services.Interfaces.IFormasPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormasPago implements IFormasPago
{
    @Autowired
    public FormasDePagoRepo repo;


    @Override
    public List<FormasDePago> getFormasPago() {
        return repo.findAll();
    }

    @Override
    public FormasDePago insertFormasPago(FormasDePago pago) {
        repo.save(pago);
        return pago;
    }

    @Override
    public FormasDePago modifyFormasPago(FormasDePago pago) {
        FormasDePago pagoAModificar = repo.findAll()
                .stream().filter(x -> x.id_forma_pago == pago.id_forma_pago).findFirst().get();
        if(pagoAModificar == null) { return  null; }
        pagoAModificar = pago;
        repo.save(pagoAModificar);
        return pago;
    }

    @Override
    public FormasDePago deleteFormasPago(Long id) {
        if(id == 0) { return null; }
        FormasDePago formasDePago = repo.findAll()
                .stream().filter(x -> x.id_forma_pago == id).findFirst().get();

        if(formasDePago == null) { return null; }

        repo.delete(formasDePago);

        return formasDePago;
    }
}

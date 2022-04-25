package com.example.CRUD.Services;

import com.example.CRUD.DTOs.ProductosDTO;
import com.example.CRUD.Models.Productos;
import com.example.CRUD.Models.Proveedores;
import com.example.CRUD.Repositories.ProductosRepo;
import com.example.CRUD.Repositories.ProveedoresRepo;
import com.example.CRUD.Services.Interfaces.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService implements IProductosService
{
    @Autowired
    public ProductosRepo repoProductos;

    @Autowired
    public ProveedoresRepo repoProveedores;

    @Override
    public List<ProductosDTO> getProductos()
    {
        List<ProductosDTO> response = new ArrayList<ProductosDTO>();
        List<Productos> prod = repoProductos.findAll();
        List<Proveedores> prov = repoProveedores.findAll();
        prod.forEach(p -> {
            response.add(new ProductosDTO(
                    p.id_producto,
                    p.descripcion,
                    prov.stream().filter(x -> x.id_proveedor == p.id_proveedor).findFirst().get().razon_social_proveedor,
                    p.stock,
                    p.importe
            ));
        });

        return response;
    }

    @Override
    public Productos insertProductos(Productos productos) {
        if(productos == null){ return null; }
        repoProductos.save(productos);
        return productos;
    }

    @Override
    public Productos modifyProductos(Productos productos) {
        Productos query = repoProductos.findAll().stream().filter(x -> x.id_producto == productos.id_producto)
                .findFirst().get();
        if(query == null) { return null; }
        query = productos;
        repoProductos.save(query);
        return query;
    }

    @Override
    public Productos deleteProductos(Long id) {
        Productos query = repoProductos.findAll().stream().filter(x -> x.id_producto == id)
                .findFirst().get();
        if(query == null) { return null; }
        repoProductos.delete(query);
        return query;
    }


}

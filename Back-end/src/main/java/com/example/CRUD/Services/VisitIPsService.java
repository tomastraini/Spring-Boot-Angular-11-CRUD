package com.example.CRUD.Services;

import com.example.CRUD.Models.VisitIPs;
import com.example.CRUD.Repositories.VisitIPsRepo;
import com.example.CRUD.Services.Interfaces.IVisitIPsService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class VisitIPsService implements IVisitIPsService
{
    public VisitIPsRepo repo;

    public VisitIPsService(VisitIPsRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<VisitIPs> getVisitas() {
        return repo.findAll();
    }

    @Override
    public VisitIPs insertVisitas(VisitIPs visitIPs)
    {
        int id = repo.findAll().stream().mapToInt(x -> x.id).max().orElse(0) + 1;
        visitIPs.id = id;
        Calendar cal = Calendar.getInstance();
        visitIPs.fecha_visita = cal.getTime();
        repo.save(visitIPs);
        return visitIPs;
    }

    @Override
    public void deleteVisita(Long id)
    {
        VisitIPs remo = repo.findAll().stream().filter(x -> x.id == id).findFirst().get();
        repo.delete(remo);
    }

    @Override
    public void deleteVisitas()
    {
        repo.deleteAll();
    }
}

package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.VisitIPs;

import java.util.List;

public interface IVisitIPsService
{
    public List<VisitIPs> getVisitas();
    public VisitIPs insertVisitas(VisitIPs visitIPs);
    public void deleteVisita(Long id);
    public void deleteVisitas();
}

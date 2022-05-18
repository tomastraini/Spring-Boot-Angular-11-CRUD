package com.example.CRUD.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("visitIPs")
public class VisitIPs
{
    public int id;
    public String ip;
    public Date fecha_visita;

    public VisitIPs() {
    }

    public VisitIPs(int id, String ip, Date fecha_visita) {
        this.id = id;
        this.ip = ip;
        this.fecha_visita = fecha_visita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(Date fecha_visita) {
        this.fecha_visita = fecha_visita;
    }
}

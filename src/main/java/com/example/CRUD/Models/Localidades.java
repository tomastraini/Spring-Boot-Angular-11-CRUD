package com.example.CRUD.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localidades")
public class Localidades {
    @Id
    @Column(name="cp")
    public int cp;
    public int id_provincia;
    public String localidad;

    public Localidades() {
    }

    public Localidades(int cp, int id_provincia, String localidad) {
        this.cp = cp;
        this.id_provincia = id_provincia;
        this.localidad = localidad;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }



}

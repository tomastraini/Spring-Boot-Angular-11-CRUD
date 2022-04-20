package com.example.CRUD.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincias {
    @Id
    @Column(name="id_provincia")
    public int id_provincia;
    public String provincia;

    public Provincias()
    {

    }

    public Provincias(int id_provincia, String provincia)
    {
        this.id_provincia = id_provincia;
        this.provincia = provincia;
    }


    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


}

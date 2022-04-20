package com.example.CRUD.DTOs;

import javax.persistence.Column;
import javax.persistence.Id;

public class LocalidadesDTO {
    public LocalidadesDTO(int cp, String provincia, String localidad, int id_provincia) {
        this.cp = cp;
        this.provincia = provincia;
        this.localidad = localidad;
        this.id_provincia = id_provincia;
    }

    public int cp;
    public String provincia;
    public String localidad;

    public int id_provincia;


    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }


    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}

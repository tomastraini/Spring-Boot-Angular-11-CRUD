package com.example.CRUD.DTOs;

public class ClientesDTO {
    public int id_cliente;
    public String razon_social;
    public String telefono;
    public String localidad;

    public ClientesDTO() {
    }

    public ClientesDTO(int id_cliente, String razon_social, String telefono, String localidad) {
        this.id_cliente = id_cliente;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public int getId() {
        return id_cliente;
    }

    public void setId(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getrazon_social() {
        return razon_social;
    }

    public void setrazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCp() {
        return localidad;
    }

    public void setCp(String localidad) {
        this.localidad = localidad;
    }
}

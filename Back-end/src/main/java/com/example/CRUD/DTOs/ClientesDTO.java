package com.example.CRUD.DTOs;

public class ClientesDTO {
    public ClientesDTO() {
    }
    public ClientesDTO(int id_cliente, String razon_social, String telefono, String localidad, int cp) {
        this.id_cliente = id_cliente;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.localidad = localidad;
        this.cp = cp;
    }
    private int id_cliente;
    private String razon_social;
    private String telefono;
    private String localidad;
    private int cp;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }



}

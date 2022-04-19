package com.example.CRUD.Models;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @Column(name="id_cliente")
    public int id_cliente;
    public String razon_social;
    public String telefono;
    public int cp;

    public Clientes() {
    }

    public Clientes(int id_cliente, String razon_social, String telefono, int cp) {
        this.id_cliente = id_cliente;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.cp = cp;
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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
}

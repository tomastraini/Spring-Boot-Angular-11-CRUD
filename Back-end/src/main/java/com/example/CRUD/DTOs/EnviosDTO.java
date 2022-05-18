package com.example.CRUD.DTOs;

import java.util.Date;

public class EnviosDTO
{
    public int id_envio;
    public String _id;
    public int id_cliente;
    public String cliente;
    public String localidad;
    public String telefono;
    public Date fecha;
    public String direccion;
    public Double costo;

    public EnviosDTO() {
    }

    public EnviosDTO(int id_envio, String _id, int id_cliente, String cliente, String localidad, String telefono, Date fecha, String direccion, Double costo) {
        this.id_envio = id_envio;
        this._id = _id;
        this.id_cliente = id_cliente;
        this.cliente = cliente;
        this.localidad = localidad;
        this.telefono = telefono;
        this.fecha = fecha;
        this.direccion = direccion;
        this.costo = costo;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}

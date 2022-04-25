package com.example.CRUD.DTOs;

import java.util.Date;

public class VentasDTO
{
    public int id_venta;
    public int id_cliente;
    public String cliente;
    public int id_forma_pago;
    public String forma_pago;
    public int id_usuario;
    public String usuario;
    public double importe;
    public Date fecha;

    public VentasDTO()
    {

    }

    public VentasDTO(int id_venta, int id_cliente, String cliente, int id_forma_pago, String forma_pago, int id_usuario, String usuario, double importe, Date fecha) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.cliente = cliente;
        this.id_forma_pago = id_forma_pago;
        this.forma_pago = forma_pago;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.importe = importe;
        this.fecha = fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(int id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

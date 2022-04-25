package com.example.CRUD.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @Column(name="id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_venta;
    public int id_cliente;
    public int id_forma_pago;
    public int id_usuario;
    public double importe;
    public Date fecha;

    public Ventas() {
    }

    public Ventas(int id_venta, int id_cliente, int id_forma_pago, int id_usuario, double importe, Date fecha) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_forma_pago = id_forma_pago;
        this.id_usuario = id_usuario;
        this.importe = importe;
        this.fecha = fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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

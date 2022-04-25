package com.example.CRUD.DTOs;

public class DetallesVentasDTO
{
    public int id_detalle_venta;
    public int id_producto;
    public int id_venta;
    public String producto;
    public double importe;
    public double cantidad;
    public double importe_r;

    public DetallesVentasDTO()
    {
    }

    public DetallesVentasDTO(int id_detalle_venta, int id_producto, int id_venta, String producto, double importe, double cantidad, double importe_r) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_producto = id_producto;
        this.id_venta = id_venta;
        this.producto = producto;
        this.importe = importe;
        this.cantidad = cantidad;
        this.importe_r = importe_r;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte_r() {
        return importe_r;
    }

    public void setImporte_r(double importe_r) {
        this.importe_r = importe_r;
    }
}

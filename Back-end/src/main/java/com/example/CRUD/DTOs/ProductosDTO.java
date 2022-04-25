package com.example.CRUD.DTOs;

public class ProductosDTO
{
    public int id_producto;
    public String descripcion;
    public String proveedor;
    public double stock;
    public double importe;

    public ProductosDTO() {
    }

    public ProductosDTO(int id_producto, String descripcion, String proveedor, double stock, double importe) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.stock = stock;
        this.importe = importe;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}

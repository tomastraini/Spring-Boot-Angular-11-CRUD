package com.example.CRUD.Models;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @Column(name="id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_producto;
    public String descripcion;
    public int id_proveedor;
    public Long stock;
    public double importe;

    public Productos() {
    }

    public Productos(int id_producto, String desripcion, int id_proveedor, Long stock, double importe) {
        this.id_producto = id_producto;
        this.descripcion = desripcion;
        this.id_proveedor = id_proveedor;
        this.stock = stock;
        this.importe = importe;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}

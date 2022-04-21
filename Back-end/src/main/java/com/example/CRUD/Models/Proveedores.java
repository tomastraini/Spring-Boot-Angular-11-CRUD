package com.example.CRUD.Models;

import javax.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedores {
    @Id
    @Column(name="id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_proveedor;
    public String razon_social_proveedor;
    public String telefono_proveedor;
    public int cp;

    public Proveedores() {
    }

    public Proveedores(int id_proveedor, String razon_social_proveedor, String telefono_proveedor, int cp) {
        this.id_proveedor = id_proveedor;
        this.razon_social_proveedor = razon_social_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.cp = cp;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRazon_social_proveedor() {
        return razon_social_proveedor;
    }

    public void setRazon_social_proveedor(String razon_social_proveedor) {
        this.razon_social_proveedor = razon_social_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
}

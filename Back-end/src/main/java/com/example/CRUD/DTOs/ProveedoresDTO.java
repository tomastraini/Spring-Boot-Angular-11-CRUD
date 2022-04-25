package com.example.CRUD.DTOs;

public class ProveedoresDTO
{
    public int id_proveedor;
    public String razon_social_proveedor;
    public String telefono_proveedor;
    public String localidad;

    public int cp;

    public ProveedoresDTO()
    {

    }

    public ProveedoresDTO(int id_proveedor, String razon_social_proveedor, String telefono_proveedor, String localidad, int cp) {
        this.id_proveedor = id_proveedor;
        this.razon_social_proveedor = razon_social_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.localidad = localidad;
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

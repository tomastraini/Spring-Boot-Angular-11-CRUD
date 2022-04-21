package com.example.CRUD.Models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_usuario;
    public String usuario;
    public String pass;
    public String permiso;

    public Usuarios() {
    }

    public Usuarios(int id_usuario, String usuario, String pass, String permiso) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.pass = pass;
        this.permiso = permiso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
}

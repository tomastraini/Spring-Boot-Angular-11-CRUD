package com.example.CRUD.Models;

import javax.persistence.*;

@Entity
@Table(name = "formas_pago")
public class FormasDePago {
    @Id
    @Column(name="id_forma_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_forma_pago;
    public String forma_pago;

    public FormasDePago() {
    }

    public FormasDePago(int id_forma_pago, String forma_pago) {
        this.id_forma_pago = id_forma_pago;
        this.forma_pago = forma_pago;
    }

    public int getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(int id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }
}

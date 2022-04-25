package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.FormasDePago;

import java.text.Normalizer;
import java.util.List;

public interface IFormasPago
{
    public List<FormasDePago> getFormasPago();
    public FormasDePago insertFormasPago(FormasDePago pago);
    public FormasDePago modifyFormasPago(FormasDePago pago);
    public FormasDePago deleteFormasPago(Long id);
}

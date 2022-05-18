package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.Whitelist;
import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IWhitelistService
{
    public List<Whitelist> getWhiteList();
    public Whitelist insertWhiteList(Whitelist w);
    Whitelist deleteWL(String _id);
}

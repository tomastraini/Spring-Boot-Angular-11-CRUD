package com.example.CRUD.Services;

import com.example.CRUD.Models.Whitelist;
import com.example.CRUD.Repositories.WhitelistRepo;
import com.example.CRUD.Services.Interfaces.IWhitelistService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WhitelistService implements IWhitelistService
{
    public WhitelistRepo repo;

    public WhitelistService(WhitelistRepo repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Whitelist> getWhiteList() {
        return repo.findAll();
    }

    public Whitelist insertWhiteList(Whitelist w)
    {
        repo.save(w);
        return w;
    }

    @Override
    public Whitelist deleteWL(String _id) {
        repo.deleteById(_id);
        return null;
    }
}

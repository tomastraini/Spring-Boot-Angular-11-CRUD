package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Whitelist;
import com.example.CRUD.Services.Interfaces.IWhitelistService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Whitelist")
@CrossOrigin
public class WhitelistController
{
    public IWhitelistService srv;

    public WhitelistController(IWhitelistService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<Whitelist>> getWhiteList()
    {
        return new ResponseEntity<>(srv.getWhiteList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Whitelist> insertWL(@RequestBody Whitelist w)
    {
        return new ResponseEntity<>(srv.insertWhiteList(w), HttpStatus.OK);
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<Whitelist> deleteWL(@PathVariable @NotNull String _id)
    {
        return new ResponseEntity<>(srv.deleteWL(_id), HttpStatus.OK);
    }

}

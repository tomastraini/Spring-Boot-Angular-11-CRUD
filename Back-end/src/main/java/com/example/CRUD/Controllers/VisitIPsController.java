package com.example.CRUD.Controllers;

import com.example.CRUD.Models.VisitIPs;
import com.example.CRUD.Services.Interfaces.IVisitIPsService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/VisitIPs")
@CrossOrigin()
public class VisitIPsController
{
    public IVisitIPsService srv;

    public VisitIPsController(IVisitIPsService srv)
    {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<VisitIPs>>  getVisitas()
    {
        return new ResponseEntity<>(srv.getVisitas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VisitIPs> postVisitas(@RequestBody VisitIPs ip)
    {
        return new ResponseEntity<>(srv.insertVisitas(ip), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVisita(@PathVariable @NotNull Long id)
    {
        srv.deleteVisita(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @DeleteMapping()
    public ResponseEntity deleteVisitas()
    {
        srv.deleteVisitas();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

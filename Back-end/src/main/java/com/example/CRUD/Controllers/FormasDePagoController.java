package com.example.CRUD.Controllers;

import com.example.CRUD.Models.FormasDePago;
import com.example.CRUD.Services.Interfaces.IFormasPago;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FormasPago")
@CrossOrigin()
public class FormasDePagoController
{
    public IFormasPago srv;

    public FormasDePagoController(IFormasPago srv) {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<FormasDePago>> getFormas()
    {
        return new ResponseEntity<>(srv.getFormasPago(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FormasDePago> insertFormas(@RequestBody FormasDePago pago)
    {
        return new ResponseEntity<>(srv.insertFormasPago(pago), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FormasDePago> modifyFormas(@RequestBody FormasDePago pago)
    {
        return new ResponseEntity<>(srv.modifyFormasPago(pago), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FormasDePago> deleteFormas(@PathVariable @NotNull Long id)
    {
        return new ResponseEntity<>(srv.deleteFormasPago(id),HttpStatus.OK);
    }
}

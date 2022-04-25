package com.example.CRUD.Controllers;

import com.example.CRUD.Models.Comments;
import com.example.CRUD.Services.Interfaces.ICommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comments")
@CrossOrigin()
public class CommentsController {
    public ICommentsService srv;

    public CommentsController(ICommentsService srv) {
        this.srv = srv;
    }

    @GetMapping
    public ResponseEntity<List<Comments>> getComments()
    {
        return new ResponseEntity<>(srv.getComments(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comments> insertComment(@RequestBody Comments comments)
    {
        return new ResponseEntity<>(srv.insertComment(comments), HttpStatus.OK);
    }
}

package com.example.CRUD.Services.Interfaces;

import com.example.CRUD.Models.Comments;

import java.util.List;

public interface ICommentsService {
    public List<Comments> getComments();
    public Comments insertComment(Comments comments);
}

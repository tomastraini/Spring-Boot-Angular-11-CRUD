package com.example.CRUD.Services;

import com.example.CRUD.Models.Comments;
import com.example.CRUD.Repositories.CommentsRepo;
import com.example.CRUD.Services.Interfaces.ICommentsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CommentsService implements ICommentsService {
    public CommentsRepo repo;

    public CommentsService(CommentsRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Comments> getComments() {
        return repo.findAll();
    }

    @Override
    public Comments insertComment(Comments comments) {
        if(comments == null) { return null; }
        Calendar cal = Calendar.getInstance();
        comments.id_comment = 0;
        comments.uploaddate = cal.getTime();
        repo.save(comments);
        return comments;
    }
}

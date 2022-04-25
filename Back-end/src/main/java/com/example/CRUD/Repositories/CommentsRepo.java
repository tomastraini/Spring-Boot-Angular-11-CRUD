package com.example.CRUD.Repositories;

import com.example.CRUD.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments, Long> {
}

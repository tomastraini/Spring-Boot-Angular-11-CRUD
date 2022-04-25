package com.example.CRUD.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @Column(name="id_comment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_comment;
    public String comment;
    public Date uploaddate;

    public Comments() {
    }

    public Comments(int id_comment, String comment, Date uploaddate) {
        this.id_comment = id_comment;
        this.comment = comment;
        this.uploaddate = uploaddate;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }
}

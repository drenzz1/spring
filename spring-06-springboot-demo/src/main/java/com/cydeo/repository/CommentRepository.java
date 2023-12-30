package com.cydeo.repository;


import com.cydeo.entity.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}

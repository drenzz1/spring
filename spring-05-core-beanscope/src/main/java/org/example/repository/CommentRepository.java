package org.example.repository;


import org.example.entity.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}

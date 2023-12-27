package org.example.proxy;


import org.example.entity.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}

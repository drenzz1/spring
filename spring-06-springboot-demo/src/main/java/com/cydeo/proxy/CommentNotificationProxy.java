package com.cydeo.proxy;


import com.cydeo.entity.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}

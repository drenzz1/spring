package org.group.proxy;

import org.group.entity.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}

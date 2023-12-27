package org.group.proxy;

import org.group.entity.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for connect : "+comment.getText());
    }
}

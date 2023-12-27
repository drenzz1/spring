package org.group.repository;

import org.group.entity.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}

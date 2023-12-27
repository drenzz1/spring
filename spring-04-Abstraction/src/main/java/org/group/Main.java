package org.group;

import org.group.config.ProjectConfig;
import org.group.entity.Comment;
import org.group.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("OZZY");
        comment.setText("Spring framework");

        ApplicationContext container = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}

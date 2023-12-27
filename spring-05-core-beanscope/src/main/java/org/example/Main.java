package org.example;


import org.example.config.ProjectConfig;
import org.example.entity.Comment;
import org.example.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("OZZY");
        comment.setText("Spring framework");

        ApplicationContext container = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = container.getBean(CommentService.class);
        CommentService commentService1 = container.getBean(CommentService.class);

        System.out.println(commentService);
        System.out.println(commentService1);

        System.out.println(commentService == commentService1);


    }
}
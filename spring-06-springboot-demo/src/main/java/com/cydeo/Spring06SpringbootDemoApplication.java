package com.cydeo;

import com.cydeo.entity.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring06SpringbootDemoApplication {

    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring framework");
        ApplicationContext context = SpringApplication.run(Spring06SpringbootDemoApplication.class, args);

        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);
    }

}

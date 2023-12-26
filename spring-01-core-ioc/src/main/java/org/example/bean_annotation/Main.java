package org.example.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor fullTimeMentor = container.getBean(FullTimeMentor.class);

        fullTimeMentor.createAccount();

        String str = container.getBean(String.class);
        System.out.println(str);


    }
}

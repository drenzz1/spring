package org.example.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor fullTimeMentor = container.getBean(FullTimeMentor.class);

        fullTimeMentor.createAccount();

        String st1 = container.getBean(String.class);
        System.out.println(st1);

        PartTimeMentor partTimeMentor=container.getBean("p2",PartTimeMentor.class);
        partTimeMentor.createAccount();



    }
}

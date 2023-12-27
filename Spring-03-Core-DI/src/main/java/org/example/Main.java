package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =  new AnnotationConfigApplicationContext(ConfigApp.class);

        Selenium selenium = context.getBean(Selenium.class);
        selenium.getTeachingHours();
    }
}
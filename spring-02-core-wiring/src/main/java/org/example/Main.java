package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new  AnnotationConfigApplicationContext(ConfigApp.class);
        Person p = container.getBean(Person.class);
        Car c = container.getBean(Car.class);
        System.out.println("Person name  = "+p.getName());
        System.out.println("Car make  = "+c.getMake());
        System.out.println("Person = " +p);

    }
}
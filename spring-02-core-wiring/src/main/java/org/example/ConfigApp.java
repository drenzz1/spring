package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    //Direct Wiring
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setCar(car());
//        p.setName("OZZY");
//        return p;
//    }
    @Bean
    Person person(Car car){
        Person p = new Person();
        p.setName("Drenzzy");
        p.setCar(car);
        return p;
    }
}

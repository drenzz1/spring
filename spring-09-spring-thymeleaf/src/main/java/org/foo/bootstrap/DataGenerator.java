package org.foo.bootstrap;

import com.github.javafaker.Faker;
import org.foo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<Student> createStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(1,90),new Faker().address().state()) );
        students.add(new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(1,90),new Faker().address().state()) );
        students.add(new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(1,90),new Faker().address().state()) );
        students.add(new Student(new Faker().name().firstName(),new Faker().name().lastName(),new Faker().number().numberBetween(1,90),new Faker().address().state()) );

        return students;
    }
}

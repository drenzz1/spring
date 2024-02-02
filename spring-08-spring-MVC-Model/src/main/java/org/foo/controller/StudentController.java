package org.foo.controller;


import org.foo.enums.Gender;
import org.foo.model.Mentor;
import org.foo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model){
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        List<String > dreni = new ArrayList<>();
        for (int i =0 ; i<1000; i++  ){
            dreni.add("student id " + i);
        }
        int dreni2 = new Random().nextInt(1,1000);
        String subject = "collections";

        model.addAttribute("subject", subject);
        model.addAttribute("student_id", dreni );
        model.addAttribute("dreni2" , dreni2);

        Student student = new Student(1L,"Dreni ","Halili");
        model.addAttribute("Student",student);

        Mentor mentor1= new Mentor("Mike" ,"Smith ",45, Gender.MALE);
        Mentor mentor2= new Mentor("Tom","Hanks ",65,Gender.MALE);
        Mentor mentor3= new Mentor("Ammy","Bryan ",25,Gender.FEMALE);

        List<Mentor> mentors = Arrays.asList(mentor1,mentor2,mentor3);

        model.addAttribute("Mentors",mentors);

        return "student/welcome";
    }


}

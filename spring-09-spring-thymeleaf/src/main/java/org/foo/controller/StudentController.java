package org.foo.controller;

import org.foo.bootstrap.DataGenerator;
import org.foo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping
    private String register(Model model){
        model.addAttribute("Students",DataGenerator.createStudent());
        return "student/register";
    }
}

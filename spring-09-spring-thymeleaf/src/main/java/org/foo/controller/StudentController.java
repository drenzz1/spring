package org.foo.controller;

import org.foo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register")
    private String register(Model model){
        model.addAttribute("Students",DataGenerator.createStudent());
        return "student/register";
    }

    @RequestMapping("/welcome")
    private String info(){
        return "student/welcome";
    }


}

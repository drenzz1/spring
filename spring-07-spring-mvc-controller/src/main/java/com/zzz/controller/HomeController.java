package com.zzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotate the class with the @Controller stereotype annotation
public class HomeController {
    @RequestMapping("/home") //Use @Requestmapping annotation to associate the action with an Httpe request path
    public String getIndex(){
        return "index.html"; //Return the html file name that cointains the details we want the broswer to display
    }
    @RequestMapping("/welcome")
    public String gethome2(){
        return "welcome.html";
    }

}

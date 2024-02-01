package com.zzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/user-info")
    public String getUserInfo(){

        return "user/user-info.html";
    }

}

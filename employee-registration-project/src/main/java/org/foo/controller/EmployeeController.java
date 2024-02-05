package org.foo.controller;

import jakarta.validation.Valid;
import org.foo.bootstrap.DataGenerator;
import org.foo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/register")
    private String createEmployee(Model model){

        model.addAttribute("states", DataGenerator.getAllStates());
        model.addAttribute("employee",new Employee());
        return "employee/employee-create";
    }
    @PostMapping("/list")
    private String employeeList(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("states",DataGenerator.getAllStates());
            return "employee/employee-create";
        }
        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees",DataGenerator.readAllEmployess());
        System.out.println(DataGenerator.getAllStates().size());
        return "employee/employee-list";
    }
}

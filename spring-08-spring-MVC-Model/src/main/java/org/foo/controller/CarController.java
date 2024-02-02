package org.foo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @RequestMapping("/info")                //localhost:8080/car/info?make=honda&year=1000
    //model=honda duhet me u pershtat me emrin e paratmetrit ne metod
    public String carInfo(@RequestParam String make ,@RequestParam  Integer year , Model model){
        model.addAttribute("carList",make );
        model.addAttribute("year",year);
        return "car/car-info";
    }
    @RequestMapping("/info2")                //localhost:8080/car/info?make=honda&year=1000
    //model=honda duhet me u pershtat me emrin e paratmetrit ne metod
    //requestparam mujna me e perdor ni parameter mrena tyne required=false edhe kjo i tregon qe munet edhe pa to hiq
    public String carInfo2(@RequestParam String make ,@RequestParam  Integer year , Model model){
        model.addAttribute("carList",make );
        model.addAttribute("year",year);
        return "car/car-info";
    }
    @RequestMapping("/info3/{make}/{year}")
    public String getCarInfo(@PathVariable String make ,@PathVariable Integer year , Model model){
        model.addAttribute("make",make);
        model.addAttribute("year",year);
        return "car/car-info";
    }
}

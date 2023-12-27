package org.example;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Selenium {

    //Field injection
//    @Autowired
    OfficeHours officeHours;




    public void getTeachingHours(){
        System.out.println("Weekly teaching hours :  " + (15 +officeHours.getHours()));
    }
}

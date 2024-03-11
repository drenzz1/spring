package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Microservice {
    private final  ExtraHours extraHours;
    public void getTotalHours(){
        System.out.println("Total hours : " +(30 + extraHours.getHours()));
    }
}

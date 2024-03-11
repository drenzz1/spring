package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.DevOps;
import stereotype_annotations.model.Microservice;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        DataStructure dsa = container.getBean(DataStructure.class);
        Microservice msa = container.getBean(Microservice.class);
        DevOps devOps = container.getBean(DevOps.class);
        dsa.getTotalHours();
        msa.getTotalHours();
        devOps.getTotalHours();
    }
}

package bean_practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
         var bean = container.getBean(FullTimeEmployee.class);
         bean.createAccount();

         var bean1 = container.getBean(PartTimeEmployee.class);
         bean1.partTimeEmployee();

    }
}

package bean_practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext container2 = new AnnotationConfigApplicationContext(AppConfig2.class);
         var bean = container.getBean(FullTimeEmployee.class);
         bean.createAccount();

         var bean1 = container.getBean(PartTimeEmployee.class);
         bean1.partTimeEmployee();


         var bean2 = container2.getBean(String.class);
         var bean3 = container2.getBean("str2",String.class);
        System.out.println(bean2);
        System.out.println(bean3);




    }
}

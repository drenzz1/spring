package org.foo;

import org.foo.config.AppConfig;
import org.foo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
         var bean = container.getBean(SalaryService.class);
        System.out.println(bean.calculateRegularySalary());
    }
}

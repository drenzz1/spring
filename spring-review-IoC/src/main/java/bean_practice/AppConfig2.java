package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig2 {
    @Bean
    @Primary
     String string1(){
        return new String("Welcome to CydeoApp");
    }
    @Bean(name = "str2")
     String string2(){
        return new String("Spring Core Practice ");
    }
}

package org.foo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Spring17RestCosnumingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestCosnumingApiApplication.class, args);
    }

    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }

}

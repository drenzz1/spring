package org.foo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@EnableFeignClients
public class Spring17RestCosnumingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestCosnumingApiApplication.class, args);
    }

    @Bean
    public MigrateResult migrateResult(DataSource dataSource){
        return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }

    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }

}

package com.example.demojpa;

import com.example.demojpa.services.PersonService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoJpaApplication {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);
        PersonService bean = context.getBean(PersonService.class);
        bean.save10Person();
        bean.printAllYoungPersons();

    }

}

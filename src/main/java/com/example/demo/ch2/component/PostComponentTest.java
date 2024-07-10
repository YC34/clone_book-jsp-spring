package com.example.demo.ch2.component;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PostComponentTest {


    @PostConstruct
    public void sayHello(){
        System.out.println("Hello World, from Spring Boot 2!");
    }
}

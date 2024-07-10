package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @SpringBootApplication 어노테이션은
 * @ComponentScan
 * @EnableAutoConfiguration
 * @ComponentScan 의 어노테이션을 포함하고 있다.
  */


@SpringBootApplication
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);

//		var ctx = SpringApplication.run(SpringStudyApplication.class, args);
//		System.out.println("# Beans: "+ctx.getBeanDefinitionCount());
//
//		var names = ctx.getBeanDefinitionNames();
//		Arrays.sort(names);
//		Arrays.asList(names).forEach(System.out::println);



	}

}

package com.example.demo.ch3_mvc;


import com.example.demo.ch3_mvc.entity.Book;
import com.example.demo.ch3_mvc.service._interfaceFile.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    // 호출 되기전에 데이터를 저장하기 위함 .
    @Bean
    public ApplicationRunner booksInitializer(BookService bookService) {
        return args -> {
            bookService.create(new Book("11111","To Kill a Mockingbird", "Harper Lee"));
            bookService.create(new Book("22222","1984", "George Orwell"));
            bookService.create(new Book("33333","The Hobbit", "J.R.R Tolkien"));
        };
    }
}

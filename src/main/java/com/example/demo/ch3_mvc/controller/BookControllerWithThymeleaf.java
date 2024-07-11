package com.example.demo.ch3_mvc.controller;


import com.example.demo.ch3_mvc.service._interfaceFile.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookControllerWithThymeleaf {

    private final BookService bookService;

    public BookControllerWithThymeleaf(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books.html")
    public String all(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping(value = "/books.html",params = "isbn")
    public String get(@RequestParam("isbn") String isbn , Model model){
        bookService.find(isbn).ifPresent(book->model.addAttribute("book", book));
        return "books/details";
    }

    // 오류 페이지 controller
    @GetMapping("/books/500")
    public void error(){
        throw new NullPointerException("Dummy NullPointerException");
    }
}

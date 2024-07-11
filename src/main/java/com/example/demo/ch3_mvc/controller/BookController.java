package com.example.demo.ch3_mvc.controller;


import com.example.demo.ch3_mvc.entity.Book;
import com.example.demo.ch3_mvc.service._interfaceFile.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> all() {
        return (Iterable<Book>) bookService.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> get(@PathVariable("isbn") String isbn) {
        return bookService.find(isbn).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book,
                                       UriComponentsBuilder uriBuilder) {
        Book created = bookService.create(book);
        URI newBookUrl = uriBuilder.path("/books/{isbn}").build(created.getIsbn());
        return ResponseEntity.created(newBookUrl).body(created);
    }





}

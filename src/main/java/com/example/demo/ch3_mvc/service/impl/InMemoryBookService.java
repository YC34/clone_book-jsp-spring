package com.example.demo.ch3_mvc.service.impl;

import com.example.demo.ch3_mvc.entity.Book;
import com.example.demo.ch3_mvc.service._interfaceFile.BookService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class InMemoryBookService implements BookService {


    // 동시성 방지를  위해 Map의 구현은 ConcurrentHashMap으로 한다?
    private final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Collection<Book> findAll() {
        return books.values();
    }

    @Override
    public Book create(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public Optional<Book> find(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }
}

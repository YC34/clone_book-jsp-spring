package com.example.demo.ch3_mvc.service._interfaceFile;

import com.example.demo.ch3_mvc.entity.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookService {

    Collection<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
}

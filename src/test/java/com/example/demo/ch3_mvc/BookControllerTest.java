package com.example.demo.ch3_mvc;


import com.example.demo.ch3_mvc.controller.BookController;
import com.example.demo.ch3_mvc.entity.Book;
import com.example.demo.ch3_mvc.service._interfaceFile.BookService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;


    @Test
    public void shouldReturnListOfBooks() throws Exception{
        Mockito.when(bookService.findAll()).thenReturn(Arrays.asList(
           new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long"),
           new Book("321","Pro Spring MVC","Marten Deinum","Colin Yates")
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].isbn",
                        Matchers.containsInAnyOrder("123","321")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].title",
                        Matchers.containsInAnyOrder("Spring 5 Recipes","Pro Spring MVC")));
    }



    @Test
    public void shouldReturn404WhenBookNotFound() throws Exception{

        Mockito.when(bookService.find(Mockito.anyString())).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/books/123"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    public void shouldReturnBookWhenFound() throws Exception{

        Mockito.when(bookService.find(Mockito.anyString()))
                .thenReturn(
                        Optional.of(new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long")));

        mockMvc.perform(MockMvcRequestBuilders.get("/books/123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isbn",
                        Matchers.equalTo("123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title",
                        Matchers.equalTo("Spring 5 Recipes")));
    }


    @Test
    public void shouldAddBook() throws Exception{
        Mockito.when(bookService.create(Mockito.any(Book.class))).thenReturn(
                new Book("123456666","Test Book Stored","T.Author"));


        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"isbn\" : \"123456666\"}, \"title\" : \"Test Book\", \"authors\" : [\"T.Author\"]"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("Location",
                        "http://localhost/books/123456666"));
    }

}

package com.example.new_website.controller;


import com.example.new_website.model.Book;
import com.example.new_website.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        List<Book> allBooks = bookService.getAllBooks();
        List<Book> featuredBooks = allBooks.stream()
                .filter(b -> !b.getId().equals(id))
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                    Collections.shuffle(collected);
                    return collected.stream().limit(5).collect(Collectors.toList());
                }));
        model.addAttribute("book", book);
        model.addAttribute("featuredBooks", featuredBooks);
        return "book_detail";
    }
}

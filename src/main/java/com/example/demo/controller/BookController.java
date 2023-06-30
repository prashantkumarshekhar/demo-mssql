package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // Add new Book
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Add more than 1 Book
    @PostMapping("/addBooks")
    public List<Book> addAllBooks(@RequestBody List<Book> books) {
        return bookService.addAllBook(books);
    }

    // Get Book by Id
    @GetMapping("/getBookByID/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookByID(id);
    }

    // Get Book by name
    @GetMapping("/getBookByName/{name}")
    public  Book getBookByName(@PathVariable String name) {
        return  bookService.getBookByName(name);
    }

    // Update Book
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book Book) {
        return bookService.updateBook(Book);
    }

    // Delete Book
    @DeleteMapping("/deleteBookById/{id}")
    public boolean deleteBookByID(@PathVariable Long id) {
        return bookService.deleteBookByID(id);
    }

    // Get all Book
    @GetMapping("/getAll")
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> addAllBook(List<Book> books) {
        return  bookRepository.saveAll(books);
    }

    public Book getBookByID(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book getBookByName(String name) {
        return  bookRepository.findByName(name);
    }

    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getBookId()).orElse(null);
        System.out.println(book);
        if(existingBook == null) {
            System.out.println("Emp not found");
            return  bookRepository.save(book);
        }else  {
        	existingBook.setName(book.getName());
        	existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            bookRepository.save(existingBook);
        }
        return existingBook;
    }

    public boolean deleteBookByID(Long id) {
        Book existingEMP = bookRepository.findById(id).get();
        if(existingEMP != null) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

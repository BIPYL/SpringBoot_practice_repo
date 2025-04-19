package com.example.rest.service;

import com.example.rest.entity.Book;
import com.example.rest.respitory.BookRespitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired //자료형을 보고 자동으로 객체 주입.
    private BookRespitory bookRespitory;

    public Book save(Book book) {
        return bookRespitory.save(book);
    }

    public List<Book> findAll() {
        return bookRespitory.findAll();
    }

    public Optional<Book> findBy(Long id) {
        return bookRespitory.findById(id);
    }

    public void delete(Book book) {
        bookRespitory.delete(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRespitory.findById(id);
    }

    public void deleteBook(Book book) {
        bookRespitory.delete(book);
    }
}


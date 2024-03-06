package com.example.libraryManagement.controller;

import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final IBookService bookService;
    @GetMapping("/all-books")
    ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
//
//    @PostMapping("/add/new-book")
//    ResponseEntity<Book> addBook( )
}

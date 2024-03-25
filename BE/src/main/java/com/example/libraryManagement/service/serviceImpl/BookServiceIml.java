package com.example.libraryManagement.service.serviceImpl;

import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.repository.BookRepository;
import com.example.libraryManagement.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceIml implements IBookService {
    private final BookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}

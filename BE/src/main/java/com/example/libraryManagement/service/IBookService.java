package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.query.params.GetBookParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    Page<BookDto> getBooks(GetBookParams getBookParams, Pageable pageable);
    BookDto createBook(UpsertBookForm upsertBookForm);

    BookDto updateBook(Long bookId, UpsertBookForm upsertBookForm);

    Object deleteBook(Long bookId);

    Object deleteMultipleBooks(List<Long> listBookIds);
}

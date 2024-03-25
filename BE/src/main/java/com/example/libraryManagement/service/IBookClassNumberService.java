package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.dto.form.UpsertBookClassNumberForm;

import java.util.List;

public interface IBookClassNumberService {
    public List<BookClassNumberDto> getAllBookClassNumbers();

    public BookClassNumberDto getBookClassNumberById(Long id);

    public BookClassNumberDto createBookClassNumber(UpsertBookClassNumberForm upsertBookClassNumberForm) ;

    public BookClassNumberDto updateBookClassNumber(Long id, UpsertBookClassNumberForm upsertBookClassNumberForm) ;

    public Object deleteBookClassNumberById(Long id) ;
}

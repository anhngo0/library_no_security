package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.dto.form.UpsertBookClassNumberForm;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.query.params.GetBookClassNumberQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookClassNumberService {
    public Page<BookClassNumberDto> getBookClassNumbers(GetBookClassNumberQueryParams getBookClassNumberQueryParams, Pageable pageable);

    public BookClassNumberDto getBookClassNumberById(Long id);

    public BookClassNumberDto createBookClassNumber(UpsertBookClassNumberForm upsertBookClassNumberForm) ;

    public BookClassNumberDto updateBookClassNumber(Long id, UpsertBookClassNumberForm upsertBookClassNumberForm) ;

    public Object deleteBookClassNumberById(Long id) ;

    List<BookClassNumberDto> createManyBookClassNumbers(List<UpsertBookClassNumberForm> upsertBookClassNumberFormList);
}

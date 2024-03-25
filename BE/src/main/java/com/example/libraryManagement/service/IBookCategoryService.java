package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.entity.BookCategory;

import java.util.List;

public interface IBookCategoryService {
    public List<BookCategoryDto> getAllBookCategories();

    BookCategoryDto getBookCategoryById(Long id);
    BookCategoryDto createBookCategory(UpsertBookCategoryForm upsertBookCategoryForm);

//    BookCategoryDto updateBookCategory(String name);
}

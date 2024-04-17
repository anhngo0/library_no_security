package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.query.params.GetBookCategoriesQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookCategoryService {
    public Page<BookCategoryDto> getBookCategories(GetBookCategoriesQueryParams getBookCategoriesQueryParams, Pageable pageable);

    BookCategoryDto getBookCategoryById(Long id);
    BookCategoryDto createBookCategory(UpsertBookCategoryForm upsertBookCategoryForm);

    BookCategoryDto updateBookCategory(Long id,UpsertBookCategoryForm upsertBookCategoryForm);

    Object deleteBookCategory(Long id);
}

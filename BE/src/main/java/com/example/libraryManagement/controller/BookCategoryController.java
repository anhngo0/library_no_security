package com.example.libraryManagement.controller;

import com.example.libraryManagement.mapper.BookCategoryMapper;
import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.service.IBookCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-category")
@RequiredArgsConstructor
public class BookCategoryController {
    @Autowired
    private final IBookCategoryService bookCategoryService;
    @GetMapping
    public ResponseEntity<List<BookCategoryDto>> getAllBookCategories(){
        return ResponseEntity.ok(bookCategoryService.getAllBookCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookCategoryDto> getBookCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(bookCategoryService.getBookCategoryById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCategoryDto> createBookCategory(
            @RequestBody @Valid UpsertBookCategoryForm upsertBookCategoryForm
    ){
        return ResponseEntity.ok(bookCategoryService.createBookCategory(upsertBookCategoryForm));
    }
    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCategoryDto> updateBookCategory(
            @PathVariable Long id,
            @RequestBody @Valid UpsertBookCategoryForm upsertBookCategoryForm
    ){
        return ResponseEntity.ok(bookCategoryService.updateBookCategory(id,upsertBookCategoryForm));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBookCategory(@PathVariable Long id){
        return ResponseEntity.ok(bookCategoryService.deleteBookCategory(id));
    }
}

package com.example.libraryManagement.controller;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.dto.form.UpsertBookClassNumberForm;
import com.example.libraryManagement.service.IBookCategoryService;
import com.example.libraryManagement.service.IBookClassNumberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/class-number")
@RequiredArgsConstructor
public class BookClassNumberController {
    @Autowired
    private final IBookClassNumberService bookClassNumberService;
    @GetMapping
    public ResponseEntity<List<BookClassNumberDto>> getAllBookCategories(){
        return ResponseEntity.ok(bookClassNumberService.getAllBookClassNumbers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookClassNumberDto> getBookClassNumberById(@PathVariable Long id){
        return ResponseEntity.ok(bookClassNumberService.getBookClassNumberById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookClassNumberDto> createBookClassNumber(
            @RequestBody @Valid UpsertBookClassNumberForm upsertBookClassNumberForm
    ){
        return ResponseEntity.ok(bookClassNumberService.createBookClassNumber(upsertBookClassNumberForm));
    }
    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookClassNumberDto> updateBookCategory(
            @PathVariable Long id,
            @RequestBody @Valid UpsertBookClassNumberForm upsertBookCategoryForm
    ){
        return ResponseEntity.ok(bookClassNumberService.updateBookClassNumber(id,upsertBookCategoryForm));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBookCategory(@PathVariable Long id){
        return ResponseEntity.ok(bookClassNumberService.deleteBookClassNumberById(id));
    }
}

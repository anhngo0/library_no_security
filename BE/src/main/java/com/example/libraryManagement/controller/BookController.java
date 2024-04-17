package com.example.libraryManagement.controller;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.query.params.GetBookParams;
import com.example.libraryManagement.service.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final IBookService bookService;
    PagedResourcesAssembler<BookDto> bookDtoPagedResourcesAssembler;
    @GetMapping()
    ResponseEntity<PagedModel<EntityModel<BookDto>>> getBooks(GetBookParams getBookParams, Pageable pageable){
        PagedModel<EntityModel<BookDto>> pagedModel = bookDtoPagedResourcesAssembler.toModel(
                bookService.getBooks(getBookParams, pageable)
        );
        return ResponseEntity.ok(pagedModel);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<BookDto> createBook(@RequestPart(name = "book") UpsertBookForm upsertBookForm){
        return ResponseEntity.ok(bookService.createBook(upsertBookForm));
    }

    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<BookDto> updateBook(@PathVariable(name = "id")  Long bookId, @RequestPart(name = "book") @Valid UpsertBookForm upsertBookForm){
        return ResponseEntity.ok(bookService.updateBook(bookId, upsertBookForm));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteBook(@PathVariable(name = "id") Long bookId){
        return ResponseEntity.ok(bookService.deleteBook(bookId));
    }

    @DeleteMapping(name = "/delete-multiple", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> deleteMultipleBooks(@RequestBody List<Long> listBookIds){
        return ResponseEntity.ok(bookService.deleteMultipleBooks(listBookIds));
    }

//
//    @PostMapping("/add/new-book")
//    ResponseEntity<Book> addBook( )
}

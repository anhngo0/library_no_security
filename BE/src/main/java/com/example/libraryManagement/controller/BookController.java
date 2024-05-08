package com.example.libraryManagement.controller;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.model.dto.fullInfo.BookFullInfoDto;
import com.example.libraryManagement.query.params.GetBookParams;
import com.example.libraryManagement.query.params.GetImportTicketParams;
import com.example.libraryManagement.query.params.GetLiquidationTicketParams;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final IBookService bookService;
    private final PagedResourcesAssembler<BookDto> bookDtoPagedResourcesAssembler;
    @GetMapping()
    ResponseEntity<PagedModel<EntityModel<BookDto>>> getBooks(GetBookParams getBookParams, Pageable pageable){
        PagedModel<EntityModel<BookDto>> pagedModel = bookDtoPagedResourcesAssembler.toModel(
                bookService.getBooks(getBookParams, pageable)
        );
        return ResponseEntity.ok(pagedModel);
    }
    @GetMapping("/{id}")
    ResponseEntity<BookFullInfoDto> getFullInfoById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookFullInfoById(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<BookDto> createBook(
            @RequestPart(name = "book") UpsertBookForm upsertBookForm,
            @RequestPart(name = "file", required = false)MultipartFile file
            ){
        return ResponseEntity.ok(bookService.createBook(upsertBookForm,file));
    }

    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<BookDto> updateBook(
            @PathVariable(name = "id")  Long bookId,
            @RequestPart(name = "book") @Valid UpsertBookForm upsertBookForm,
            @RequestPart(name = "file")MultipartFile file
    ){
        return ResponseEntity.ok(bookService.updateBook(bookId, upsertBookForm, file));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteBook(@PathVariable(name = "id") Long bookId){
        return ResponseEntity.ok(bookService.deleteBook(bookId));
    }

    @DeleteMapping(name = "/delete-multiple", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> deleteMultipleBooks(@RequestBody List<Long> listBookIds){
        return ResponseEntity.ok(bookService.deleteMultipleBooks(listBookIds));
    }

//    GET API CALLED WHEN USER ENTER LIQUIDATION TICKET FULL INFORMATION PAGE
    @GetMapping("/liquidation-full-info")
    public ResponseEntity<PagedModel<EntityModel<BookDto>>> getBooksByLiquidationTicketId(
            GetLiquidationTicketParams getLiquidationTicketParams, Pageable pageable){
        PagedModel<EntityModel<BookDto>> page = bookDtoPagedResourcesAssembler.toModel(bookService.getBooksByLiquidationTicketId(getLiquidationTicketParams,pageable));
        return ResponseEntity.ok(page);
    }
//books info related to borrow ticket are gotten through dto so no need to call api to get them
}

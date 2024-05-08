package com.example.libraryManagement.service.serviceImpl;

import com.example.libraryManagement.exeption.ResourceNotFoundException;
import com.example.libraryManagement.mapper.BookMapper;
import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.model.dto.fullInfo.BookFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookStatus;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.repository.BookRepository;
import com.example.libraryManagement.query.params.GetBookParams;
import com.example.libraryManagement.query.params.GetLiquidationTicketParams;
import com.example.libraryManagement.query.predicate.BookPredicate;
import com.example.libraryManagement.service.IBookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class BookServiceIml implements IBookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final FileStorageService fileStorageService;

    public Page<BookDto> getBooks(GetBookParams getBookParams, Pageable pageable){
        return bookRepository
                .findAll(BookPredicate.getBooks(getBookParams), pageable)
                .map(bookMapper::toDto)
                ;
    }

    @Override
    @Transactional
    public BookDto createBook(UpsertBookForm upsertBookForm, MultipartFile file) {
        Book newBook = bookMapper.toEntity(upsertBookForm);
        newBook.setStatus(BookStatus.IN_USE);
        //add class number before typed book position
//        newBook.addClassNumberToBookPosition();
        newBook = bookRepository.save(newBook);
        Book book = newBook;
        CompletableFuture.runAsync(() -> {
             fileStorageService.uploadMultipleFiles(
                    book.getId(),
                    Book.class.getSimpleName(),
                    FileDescription.IMAGE,
                    file
            );
        });
        return bookMapper.toDto(newBook);
    }

    @Override
    public BookDto updateBook(Long bookId, UpsertBookForm upsertBookForm, MultipartFile file) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        Book updatedbook = bookMapper.toEntity_updateBook(book, upsertBookForm);
        updatedbook = bookRepository.save(updatedbook);
        if (file != null && !file.isEmpty()) {
            fileStorageService.deleteAllFilesOfAnEntity(Book.class.getSimpleName(), bookId, FileDescription.IMAGE);
            fileStorageService.uploadMultipleFiles( bookId,Book.class.getSimpleName(), FileDescription.IMAGE, file);

        }
        return bookMapper.toDto(updatedbook);
    }

    @Override
    @Transactional
    public Object deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        bookRepository.delete(book);
        return null;
    }

    @Override
    public Object deleteMultipleBooks(List<Long> listBookIds) {
        if(!listBookIds.isEmpty()){
            bookRepository.deleteAllById(listBookIds);
        };
        return null;
    }

    @Override
    public BookFullInfoDto getBookFullInfoById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
        return bookMapper.toFullInfoDto(book);
    }

    @Override
    public Page<BookDto> getBooksByLiquidationTicketId(GetLiquidationTicketParams getLiquidationTicketParams, Pageable pageable) {
        return bookRepository
                .findAll(BookPredicate.getBooksByLiquidationTicketId(getLiquidationTicketParams), pageable)
                .map(bookMapper::toDto);
    }

    @Override
    public void setBookState(Set<Book> books, BookStatus status){
        books.forEach(book -> book.setStatus(status));
        bookRepository.saveAll(books);
    }
}

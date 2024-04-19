package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.BookClassNumber;
import com.example.libraryManagement.model.entity.BookStatus;
import java.math.BigInteger;
import java.time.Year;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-19T11:52:29+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl extends BookMapper {

    @Autowired
    private IdToEntityMapper idToEntityMapper;

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setCategoryId( bookCategoryId( book ) );
        bookDto.setClassNumberId( bookClassNumberId( book ) );
        bookDto.setId( book.getId() );
        bookDto.setVietnameseName( book.getVietnameseName() );
        bookDto.setAlterName( book.getAlterName() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setISBNNumber( book.getISBNNumber() );
        bookDto.setBookPosition( book.getBookPosition() );
        bookDto.setPrice( book.getPrice() );
        bookDto.setQuantity( book.getQuantity() );
        bookDto.setYear_of_publication( book.getYear_of_publication() );
        bookDto.setPublisher( book.getPublisher() );
        bookDto.setLanguage( book.getLanguage() );
        bookDto.setDescription( book.getDescription() );
        bookDto.setStatus( book.getStatus() );

        return bookDto;
    }

    @Override
    public Book toEntity(UpsertBookForm upsertBookForm) {
        if ( upsertBookForm == null ) {
            return null;
        }

        BookCategory category = null;
        BookClassNumber classNumber = null;
        String vietnameseName = null;
        String alterName = null;
        String author = null;
        BigInteger iSBNNumber = null;
        String bookPosition = null;
        Double price = null;
        int quantity = 0;
        Year year_of_publication = null;
        String publisher = null;
        String language = null;
        String description = null;
        BookStatus status = null;

        category = idToEntityMapper.toCategory( upsertBookForm.getCategoryId() );
        classNumber = idToEntityMapper.toClassNumber( upsertBookForm.getClassNumberId() );
        vietnameseName = upsertBookForm.getVietnameseName();
        alterName = upsertBookForm.getAlterName();
        author = upsertBookForm.getAuthor();
        iSBNNumber = upsertBookForm.getISBNNumber();
        bookPosition = upsertBookForm.getBookPosition();
        price = upsertBookForm.getPrice();
        quantity = upsertBookForm.getQuantity();
        year_of_publication = upsertBookForm.getYear_of_publication();
        publisher = upsertBookForm.getPublisher();
        language = upsertBookForm.getLanguage();
        description = upsertBookForm.getDescription();
        status = upsertBookForm.getStatus();

        Long id = null;

        Book book = new Book( id, vietnameseName, alterName, author, iSBNNumber, bookPosition, price, quantity, year_of_publication, publisher, language, description, status, category, classNumber );

        return book;
    }

    @Override
    public Book toEntity_updateBook(Book book, UpsertBookForm upsertBookForm) {
        if ( upsertBookForm == null ) {
            return book;
        }

        if ( upsertBookForm.getCategoryId() != null ) {
            book.setCategory( idToEntityMapper.toCategory( upsertBookForm.getCategoryId() ) );
        }
        if ( upsertBookForm.getClassNumberId() != null ) {
            book.setClassNumber( idToEntityMapper.toClassNumber( upsertBookForm.getClassNumberId() ) );
        }
        if ( upsertBookForm.getVietnameseName() != null ) {
            book.setVietnameseName( upsertBookForm.getVietnameseName() );
        }
        if ( upsertBookForm.getAlterName() != null ) {
            book.setAlterName( upsertBookForm.getAlterName() );
        }
        if ( upsertBookForm.getAuthor() != null ) {
            book.setAuthor( upsertBookForm.getAuthor() );
        }
        if ( upsertBookForm.getISBNNumber() != null ) {
            book.setISBNNumber( upsertBookForm.getISBNNumber() );
        }
        if ( upsertBookForm.getBookPosition() != null ) {
            book.setBookPosition( upsertBookForm.getBookPosition() );
        }
        if ( upsertBookForm.getPrice() != null ) {
            book.setPrice( upsertBookForm.getPrice() );
        }
        book.setQuantity( upsertBookForm.getQuantity() );
        if ( upsertBookForm.getYear_of_publication() != null ) {
            book.setYear_of_publication( upsertBookForm.getYear_of_publication() );
        }
        if ( upsertBookForm.getPublisher() != null ) {
            book.setPublisher( upsertBookForm.getPublisher() );
        }
        if ( upsertBookForm.getLanguage() != null ) {
            book.setLanguage( upsertBookForm.getLanguage() );
        }
        if ( upsertBookForm.getDescription() != null ) {
            book.setDescription( upsertBookForm.getDescription() );
        }
        if ( upsertBookForm.getStatus() != null ) {
            book.setStatus( upsertBookForm.getStatus() );
        }

        return book;
    }

    private Long bookCategoryId(Book book) {
        if ( book == null ) {
            return null;
        }
        BookCategory category = book.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long bookClassNumberId(Book book) {
        if ( book == null ) {
            return null;
        }
        BookClassNumber classNumber = book.getClassNumber();
        if ( classNumber == null ) {
            return null;
        }
        Long id = classNumber.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

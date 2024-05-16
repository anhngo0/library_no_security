package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.BookExcelDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.model.dto.form.UpsertExcelBookForm;
import com.example.libraryManagement.model.dto.fullInfo.BookFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.BookClassNumber;
import com.example.libraryManagement.model.entity.BookStatus;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T11:01:50+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl extends BookMapper {

    @Autowired
    private IdToEntityMapper idToEntityMapper;
    @Autowired
    private LiquidationMapper liquidationMapper;
    @Autowired
    private NameToEntityMapper nameToEntityMapper;

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitleName( book.getTitleName() );
        bookDto.setAlterName( book.getAlterName() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setBorrowed( book.isBorrowed() );
        bookDto.setBookPosition( book.getBookPosition() );
        bookDto.setPrice( book.getPrice() );
        bookDto.setQuantity( book.getQuantity() );
        bookDto.setStatus( book.getStatus() );
        bookDto.setCategory( bookCategoryToBookCategoryDto( book.getCategory() ) );
        bookDto.setClassNumber( bookClassNumberToBookClassNumberDto( book.getClassNumber() ) );

        return bookDto;
    }

    @Override
    public BookExcelDto toExcelDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookExcelDto bookExcelDto = new BookExcelDto();

        bookExcelDto.setCategory( bookCategoryName( book ) );
        bookExcelDto.setClassNumber( bookClassNumberName( book ) );
        bookExcelDto.setTitleName( book.getTitleName() );
        bookExcelDto.setAlterName( book.getAlterName() );
        bookExcelDto.setAuthor( book.getAuthor() );
        bookExcelDto.setBookPosition( book.getBookPosition() );
        bookExcelDto.setQuantity( book.getQuantity() );
        bookExcelDto.setLanguage( book.getLanguage() );
        bookExcelDto.setPublisher( book.getPublisher() );
        bookExcelDto.setYear_of_publication( book.getYear_of_publication() );
        bookExcelDto.setISBNNumber( book.getISBNNumber() );

        return bookExcelDto;
    }

    @Override
    public Book toEntity(UpsertExcelBookForm upsertExcelBookForm) {
        if ( upsertExcelBookForm == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitleName( upsertExcelBookForm.getTitleName() );
        book.setAlterName( upsertExcelBookForm.getAlterName() );
        book.setISBNNumber( upsertExcelBookForm.getISBNNumber() );
        book.setAuthor( upsertExcelBookForm.getAuthor() );
        book.setBookPosition( upsertExcelBookForm.getBookPosition() );
        book.setPrice( upsertExcelBookForm.getPrice() );
        book.setQuantity( upsertExcelBookForm.getQuantity() );
        book.setYear_of_publication( upsertExcelBookForm.getYear_of_publication() );
        book.setPublisher( upsertExcelBookForm.getPublisher() );
        book.setLanguage( upsertExcelBookForm.getLanguage() );
        book.setDescription( upsertExcelBookForm.getDescription() );
        book.setCategory( nameToEntityMapper.toCategory( upsertExcelBookForm.getCategory() ) );
        book.setClassNumber( nameToEntityMapper.toClassNumber( upsertExcelBookForm.getClassNumber() ) );

        book.setStatus( BookStatus.IN_USE );

        return book;
    }

    @Override
    public BookFullInfoDto toFullInfoDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookFullInfoDto bookFullInfoDto = new BookFullInfoDto();

        bookFullInfoDto.setId( book.getId() );
        bookFullInfoDto.setTitleName( book.getTitleName() );
        bookFullInfoDto.setAlterName( book.getAlterName() );
        bookFullInfoDto.setAuthor( book.getAuthor() );
        bookFullInfoDto.setISBNNumber( book.getISBNNumber() );
        bookFullInfoDto.setBookPosition( book.getBookPosition() );
        bookFullInfoDto.setPrice( book.getPrice() );
        bookFullInfoDto.setQuantity( book.getQuantity() );
        bookFullInfoDto.setYear_of_publication( book.getYear_of_publication() );
        bookFullInfoDto.setPublisher( book.getPublisher() );
        bookFullInfoDto.setLanguage( book.getLanguage() );
        bookFullInfoDto.setDescription( book.getDescription() );
        bookFullInfoDto.setBorrowed( book.isBorrowed() );
        bookFullInfoDto.setStatus( book.getStatus() );
        bookFullInfoDto.setCategory( bookCategoryToBookCategoryDto( book.getCategory() ) );
        bookFullInfoDto.setClassNumber( bookClassNumberToBookClassNumberDto( book.getClassNumber() ) );
        bookFullInfoDto.setLiquidationTicket( liquidationMapper.toDto( book.getLiquidationTicket() ) );

        return bookFullInfoDto;
    }

    @Override
    public Book toEntity(UpsertBookForm upsertBookForm) {
        if ( upsertBookForm == null ) {
            return null;
        }

        Book book = new Book();

        book.setCategory( idToEntityMapper.toCategory( upsertBookForm.getCategoryId() ) );
        book.setClassNumber( idToEntityMapper.toClassNumber( upsertBookForm.getClassNumberId() ) );
        book.setTitleName( upsertBookForm.getTitleName() );
        book.setAlterName( upsertBookForm.getAlterName() );
        book.setISBNNumber( upsertBookForm.getISBNNumber() );
        book.setAuthor( upsertBookForm.getAuthor() );
        book.setBookPosition( upsertBookForm.getBookPosition() );
        book.setPrice( upsertBookForm.getPrice() );
        book.setQuantity( upsertBookForm.getQuantity() );
        book.setYear_of_publication( upsertBookForm.getYear_of_publication() );
        book.setPublisher( upsertBookForm.getPublisher() );
        book.setLanguage( upsertBookForm.getLanguage() );
        book.setDescription( upsertBookForm.getDescription() );

        book.setStatus( BookStatus.IN_USE );

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
        if ( upsertBookForm.getTitleName() != null ) {
            book.setTitleName( upsertBookForm.getTitleName() );
        }
        if ( upsertBookForm.getAlterName() != null ) {
            book.setAlterName( upsertBookForm.getAlterName() );
        }
        if ( upsertBookForm.getISBNNumber() != null ) {
            book.setISBNNumber( upsertBookForm.getISBNNumber() );
        }
        if ( upsertBookForm.getAuthor() != null ) {
            book.setAuthor( upsertBookForm.getAuthor() );
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

        return book;
    }

    protected BookCategoryDto bookCategoryToBookCategoryDto(BookCategory bookCategory) {
        if ( bookCategory == null ) {
            return null;
        }

        BookCategoryDto bookCategoryDto = new BookCategoryDto();

        bookCategoryDto.setId( bookCategory.getId() );
        bookCategoryDto.setName( bookCategory.getName() );
        bookCategoryDto.setNote( bookCategory.getNote() );

        return bookCategoryDto;
    }

    protected BookClassNumberDto bookClassNumberToBookClassNumberDto(BookClassNumber bookClassNumber) {
        if ( bookClassNumber == null ) {
            return null;
        }

        BookClassNumberDto bookClassNumberDto = new BookClassNumberDto();

        bookClassNumberDto.setId( bookClassNumber.getId() );
        bookClassNumberDto.setName( bookClassNumber.getName() );

        return bookClassNumberDto;
    }

    private String bookCategoryName(Book book) {
        if ( book == null ) {
            return null;
        }
        BookCategory category = book.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String bookClassNumberName(Book book) {
        if ( book == null ) {
            return null;
        }
        BookClassNumber classNumber = book.getClassNumber();
        if ( classNumber == null ) {
            return null;
        }
        String name = classNumber.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}

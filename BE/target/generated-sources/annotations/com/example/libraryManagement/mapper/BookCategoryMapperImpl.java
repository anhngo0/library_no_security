package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.entity.BookCategory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-15T01:12:29+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BookCategoryMapperImpl extends BookCategoryMapper {

    @Override
    public BookCategoryDto toDto(BookCategory bookCategory) {
        if ( bookCategory == null ) {
            return null;
        }

        BookCategoryDto bookCategoryDto = new BookCategoryDto();

        bookCategoryDto.setId( bookCategory.getId() );
        bookCategoryDto.setName( bookCategory.getName() );
        bookCategoryDto.setNote( bookCategory.getNote() );

        return bookCategoryDto;
    }

    @Override
    public BookCategory toEntity(BookCategoryDto bookCategoryDto) {
        if ( bookCategoryDto == null ) {
            return null;
        }

        BookCategory bookCategory = new BookCategory();

        bookCategory.setId( bookCategoryDto.getId() );
        bookCategory.setName( bookCategoryDto.getName() );
        bookCategory.setNote( bookCategoryDto.getNote() );

        return bookCategory;
    }

    @Override
    public BookCategory toEntity(UpsertBookCategoryForm upsertBookCategoryForm) {
        if ( upsertBookCategoryForm == null ) {
            return null;
        }

        BookCategory bookCategory = new BookCategory();

        bookCategory.setName( upsertBookCategoryForm.getName() );
        bookCategory.setNote( upsertBookCategoryForm.getNote() );

        return bookCategory;
    }

    @Override
    public BookCategory toEntityUpdate(UpsertBookCategoryForm upsertBookCategoryForm, BookCategory bookCategory) {
        if ( upsertBookCategoryForm == null ) {
            return bookCategory;
        }

        bookCategory.setName( upsertBookCategoryForm.getName() );
        bookCategory.setNote( upsertBookCategoryForm.getNote() );

        return bookCategory;
    }
}

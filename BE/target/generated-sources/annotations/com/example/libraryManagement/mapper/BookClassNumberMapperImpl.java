package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.form.UpsertBookClassNumberForm;
import com.example.libraryManagement.model.entity.BookClassNumber;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T00:47:07+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BookClassNumberMapperImpl extends BookClassNumberMapper {

    @Override
    public BookClassNumberDto toDto(BookClassNumber bookClassNumber) {
        if ( bookClassNumber == null ) {
            return null;
        }

        BookClassNumberDto bookClassNumberDto = new BookClassNumberDto();

        bookClassNumberDto.setId( bookClassNumber.getId() );
        bookClassNumberDto.setClassNumber( bookClassNumber.getClassNumber() );

        return bookClassNumberDto;
    }

    @Override
    public BookClassNumber toEntity(BookClassNumberDto bookClassNumberDto) {
        if ( bookClassNumberDto == null ) {
            return null;
        }

        BookClassNumber bookClassNumber = new BookClassNumber();

        bookClassNumber.setId( bookClassNumberDto.getId() );
        bookClassNumber.setClassNumber( bookClassNumberDto.getClassNumber() );

        return bookClassNumber;
    }

    @Override
    public BookClassNumber toEntity(UpsertBookClassNumberForm upsertBookClassNumberForm) {
        if ( upsertBookClassNumberForm == null ) {
            return null;
        }

        BookClassNumber bookClassNumber = new BookClassNumber();

        bookClassNumber.setClassNumber( upsertBookClassNumberForm.getClassNumber() );

        return bookClassNumber;
    }

    @Override
    public BookClassNumber toEntityUpdate(UpsertBookClassNumberForm upsertBookClassNumberForm, BookClassNumber bookClassNumber) {
        if ( upsertBookClassNumberForm == null ) {
            return bookClassNumber;
        }

        bookClassNumber.setClassNumber( upsertBookClassNumberForm.getClassNumber() );

        return bookClassNumber;
    }
}

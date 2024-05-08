package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.form.UpsertBookClassNumberForm;
import com.example.libraryManagement.model.entity.BookClassNumber;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T15:31:29+0700",
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
        bookClassNumberDto.setName( bookClassNumber.getName() );

        return bookClassNumberDto;
    }

    @Override
    public BookClassNumber toEntity(BookClassNumberDto bookClassNumberDto) {
        if ( bookClassNumberDto == null ) {
            return null;
        }

        BookClassNumber bookClassNumber = new BookClassNumber();

        bookClassNumber.setId( bookClassNumberDto.getId() );
        bookClassNumber.setName( bookClassNumberDto.getName() );

        return bookClassNumber;
    }

    @Override
    public BookClassNumber toEntity(UpsertBookClassNumberForm upsertBookClassNumberForm) {
        if ( upsertBookClassNumberForm == null ) {
            return null;
        }

        BookClassNumber bookClassNumber = new BookClassNumber();

        bookClassNumber.setName( upsertBookClassNumberForm.getName() );

        return bookClassNumber;
    }

    @Override
    public BookClassNumber toEntityUpdate(UpsertBookClassNumberForm upsertBookClassNumberForm, BookClassNumber bookClassNumber) {
        if ( upsertBookClassNumberForm == null ) {
            return bookClassNumber;
        }

        bookClassNumber.setName( upsertBookClassNumberForm.getName() );

        return bookClassNumber;
    }
}

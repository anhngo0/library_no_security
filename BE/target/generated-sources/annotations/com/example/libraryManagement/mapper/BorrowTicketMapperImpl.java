package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.BookClassNumberDto;
import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.BorrowTicketDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.AcceptBorrowTicketForm;
import com.example.libraryManagement.model.dto.form.CreateBorrowTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.BorrowTicketFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.BookClassNumber;
import com.example.libraryManagement.model.entity.BorrowTicket;
import com.example.libraryManagement.model.entity.Profile;
import com.example.libraryManagement.model.entity.TicketStatus;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T10:00:03+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BorrowTicketMapperImpl extends BorrowTicketMapper {

    @Autowired
    private IdToEntityMapper idToEntityMapper;

    @Override
    public BorrowTicketDto toDto(BorrowTicket borrowTicket) {
        if ( borrowTicket == null ) {
            return null;
        }

        BorrowTicketDto borrowTicketDto = new BorrowTicketDto();

        borrowTicketDto.setMember( borrowTicketMemberName( borrowTicket ) );
        borrowTicketDto.setLibrarian( borrowTicketLibrarianName( borrowTicket ) );
        borrowTicketDto.setId( borrowTicket.getId() );
        borrowTicketDto.setBorrowed_date( borrowTicket.getBorrowed_date() );
        borrowTicketDto.setReturned_date( borrowTicket.getReturned_date() );
        borrowTicketDto.setStatus( borrowTicket.getStatus() );

        return borrowTicketDto;
    }

    @Override
    public BorrowTicketFullInfoDto toFullInfoDto(BorrowTicket borrowTicket) {
        if ( borrowTicket == null ) {
            return null;
        }

        BorrowTicketFullInfoDto borrowTicketFullInfoDto = new BorrowTicketFullInfoDto();

        borrowTicketFullInfoDto.setId( borrowTicket.getId() );
        borrowTicketFullInfoDto.setBorrowed_date( borrowTicket.getBorrowed_date() );
        borrowTicketFullInfoDto.setReturned_date( borrowTicket.getReturned_date() );
        borrowTicketFullInfoDto.setMember( profileToProfileMinInfoDto( borrowTicket.getMember() ) );
        borrowTicketFullInfoDto.setLibrarian( profileToProfileMinInfoDto( borrowTicket.getLibrarian() ) );
        borrowTicketFullInfoDto.setNote( borrowTicket.getNote() );
        borrowTicketFullInfoDto.setStatus( borrowTicket.getStatus() );
        borrowTicketFullInfoDto.setBooks( bookSetToBookDtoSet( borrowTicket.getBooks() ) );

        return borrowTicketFullInfoDto;
    }

    @Override
    public BorrowTicket toEntity_create(CreateBorrowTicketForm createBorrowTicketForm) {
        if ( createBorrowTicketForm == null ) {
            return null;
        }

        BorrowTicket borrowTicket = new BorrowTicket();

        borrowTicket.setLibrarian( idToEntityMapper.toProfile( createBorrowTicketForm.getLibrarianId() ) );
        borrowTicket.setMember( idToEntityMapper.toProfile( createBorrowTicketForm.getMemberId() ) );
        borrowTicket.setBooks( idToEntityMapper.toBooks( createBorrowTicketForm.getBookIds() ) );
        borrowTicket.setBorrowed_date( createBorrowTicketForm.getBorrowed_date() );
        borrowTicket.setNote( createBorrowTicketForm.getNote() );

        borrowTicket.setStatus( TicketStatus.PENDING );

        return borrowTicket;
    }

    @Override
    public BorrowTicket toEntity_accept(AcceptBorrowTicketForm acceptBorrowTicketForm, BorrowTicket borrowTicket) {
        if ( acceptBorrowTicketForm == null ) {
            return borrowTicket;
        }

        borrowTicket.setReturned_date( acceptBorrowTicketForm.getReturned_date() );
        borrowTicket.setNote( acceptBorrowTicketForm.getNote() );

        borrowTicket.setStatus( TicketStatus.ACCEPT );

        return borrowTicket;
    }

    @Override
    public BorrowTicket toEntity_update(CreateBorrowTicketForm createBorrowTicketForm, BorrowTicket borrowTicket) {
        if ( createBorrowTicketForm == null ) {
            return borrowTicket;
        }

        borrowTicket.setLibrarian( idToEntityMapper.toProfile( createBorrowTicketForm.getLibrarianId() ) );
        borrowTicket.setMember( idToEntityMapper.toProfile( createBorrowTicketForm.getMemberId() ) );
        if ( borrowTicket.getBooks() != null ) {
            Set<Book> set = idToEntityMapper.toBooks( createBorrowTicketForm.getBookIds() );
            if ( set != null ) {
                borrowTicket.getBooks().clear();
                borrowTicket.getBooks().addAll( set );
            }
            else {
                borrowTicket.setBooks( null );
            }
        }
        else {
            Set<Book> set = idToEntityMapper.toBooks( createBorrowTicketForm.getBookIds() );
            if ( set != null ) {
                borrowTicket.setBooks( set );
            }
        }
        borrowTicket.setBorrowed_date( createBorrowTicketForm.getBorrowed_date() );
        borrowTicket.setNote( createBorrowTicketForm.getNote() );

        return borrowTicket;
    }

    private String borrowTicketMemberName(BorrowTicket borrowTicket) {
        if ( borrowTicket == null ) {
            return null;
        }
        Profile member = borrowTicket.getMember();
        if ( member == null ) {
            return null;
        }
        String name = member.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String borrowTicketLibrarianName(BorrowTicket borrowTicket) {
        if ( borrowTicket == null ) {
            return null;
        }
        Profile librarian = borrowTicket.getLibrarian();
        if ( librarian == null ) {
            return null;
        }
        String name = librarian.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected ProfileMinInfoDto profileToProfileMinInfoDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileMinInfoDto profileMinInfoDto = new ProfileMinInfoDto();

        profileMinInfoDto.setId( profile.getId() );
        profileMinInfoDto.setName( profile.getName() );
        profileMinInfoDto.setPhone( profile.getPhone() );
        profileMinInfoDto.setEmail( profile.getEmail() );

        return profileMinInfoDto;
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

    protected BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setVietnameseName( book.getVietnameseName() );
        bookDto.setAlterName( book.getAlterName() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setBookPosition( book.getBookPosition() );
        bookDto.setPrice( book.getPrice() );
        bookDto.setQuantity( book.getQuantity() );
        bookDto.setStatus( book.getStatus() );
        bookDto.setCategory( bookCategoryToBookCategoryDto( book.getCategory() ) );
        bookDto.setClassNumber( bookClassNumberToBookClassNumberDto( book.getClassNumber() ) );

        return bookDto;
    }

    protected Set<BookDto> bookSetToBookDtoSet(Set<Book> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookDto> set1 = new LinkedHashSet<BookDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Book book : set ) {
            set1.add( bookToBookDto( book ) );
        }

        return set1;
    }
}

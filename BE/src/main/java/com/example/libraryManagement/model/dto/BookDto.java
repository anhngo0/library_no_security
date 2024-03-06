package com.example.libraryManagement.model.dto;

import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.BookClassNumber;
import com.example.libraryManagement.model.entity.BorrowedTicket;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDto {
    private Long bookId;
    private String vietnameseName;
    private String foreignName;
    private String author;
    private BigInteger ISBNNumber;
    private Date publishDate;
    private String publisher;
    private String language;
    private String description;
    private String callNumber;
    private boolean isBorrowed = false;

    private BookCategoryDto categoryDto;

    private BookCategory classNumber;

    List<BorrowedTicket> borrowedTickets;
}

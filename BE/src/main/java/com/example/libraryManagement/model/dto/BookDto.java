package com.example.libraryManagement.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDto implements Serializable {
    private Long bookId;
    private String vietnameseName;
    private String alterName;
    private String author;
    private BigInteger ISBNNumber;
    private Double import_price;
    private Date year_of_publication;
    private String publisher;
    private String language;
    private String description;
    private BookCategoryDto categoryDto;

    private BookClassNumberDto classNumber;

    List<BorrowedTicketDto> borrowedTickets;
}

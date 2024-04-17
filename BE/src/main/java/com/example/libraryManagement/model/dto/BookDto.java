package com.example.libraryManagement.model.dto;

import com.example.libraryManagement.model.entity.BookStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDto implements Serializable {
    private Long id;
    private String vietnameseName;
    private String alterName;
    private String author;
    private BigInteger ISBNNumber;
    private String bookPosition;
    private Double price;
    private int quantity;
    private Year year_of_publication;
    private String publisher;
    private String language;
    private String description;
    private BookStatus status;
    private Long categoryId;

    private Long classNumberId;

//    List<BorrowedTicketDto> borrowedTickets;
}

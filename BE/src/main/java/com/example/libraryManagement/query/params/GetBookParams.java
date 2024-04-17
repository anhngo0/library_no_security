package com.example.libraryManagement.query.params;

import com.example.libraryManagement.model.entity.BookStatus;
import lombok.Data;

import java.math.BigInteger;
import java.time.Year;

@Data
public class GetBookParams {
    private String keyword;
    private String vietnameseName;
    private String alterName;
    private String author;
    private BigInteger ISBNNumber;
    private String bookPosition;
    private Double import_price;
    private Year year_of_publication;
    private String publisher;
    private String language;
    private String description;
    private BookStatus status;
    private Long categoryId;
    private Long classNumberId;
}

package com.example.libraryManagement.query.params;

import com.example.libraryManagement.model.entity.BookStatus;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.Year;

@Data
public class GetBookParams implements Serializable {
    private String keyword;
    private Year yearOfPublicationFrom;
    private Year yearOfPublicationTo;
    private int quantityFrom;
    private int quantityTo;
    private Long categoryId;
    private Long classNumberId;
}

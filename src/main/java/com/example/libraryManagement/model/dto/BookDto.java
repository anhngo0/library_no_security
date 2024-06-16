package com.example.libraryManagement.model.dto;

import com.example.libraryManagement.model.entity.BookClassNumber;
import com.example.libraryManagement.model.entity.BookStatus;
import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.List;
//Need to add a BooKFullInfoDTO CLASS for get detail info when click in each book (2/5)
@Data
@NoArgsConstructor
public class BookDto implements Serializable {
    private Long id;
    private String titleName;
    private String alterName;
    private String author;
    private boolean isBorrowed;
    private String bookPosition;
    private Double price;
    private int quantity;
    private BookStatus status;
    private BookCategoryDto category ;
    private BookClassNumberDto classNumber;

}

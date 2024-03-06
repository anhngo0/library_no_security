package com.example.libraryManagement.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class BorrowedTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date borrowDate;
    //date that people promise to return books they borrowed
    private Date PromisedReturnDate;
    //date that they really return the books
    private Date returnDate;

    @ManyToMany(mappedBy = "borrowedTickets")
    List<Book> books;

    public BorrowedTicket(List<Book> books) {
        this.books = books;
    }

    public void addBorrowedTicket(Book borrowedBook){
        if(books == null){
            this.books = new ArrayList<Book>();
        }
        books.add(borrowedBook);
    }

}

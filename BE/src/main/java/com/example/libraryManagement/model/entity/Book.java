package com.example.libraryManagement.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(targetEntity = BookCategory.class)
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToOne(targetEntity = BookClassNumber.class)
    @JoinColumn(name = "classNumber_id")
    private BookCategory classNumber;

    @ManyToMany
    @JoinTable(
            name = "borrow_book",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "borrowedTicketId")
    )
    List<BorrowedTicket> borrowedTickets;

    public Book() {
        this.borrowedTickets = new ArrayList<BorrowedTicket>();
    }

    //set book's state to true when someone borrow it & false when they don't
    public void setIsBorrowedToTrue(){
        this.isBorrowed = true;
    }
    public void setIsBorrowedToFalse(){
        this.isBorrowed = false;
    }

    public void addBorrowedTicket(BorrowedTicket newBorrowedTicket){
        if(borrowedTickets == null){
            this.borrowedTickets = new ArrayList<BorrowedTicket>();
        }
        borrowedTickets.add(newBorrowedTicket);
    }
}

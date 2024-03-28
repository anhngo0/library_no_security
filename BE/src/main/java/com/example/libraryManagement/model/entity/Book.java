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
    @Column(nullable = false, name = "id")
    private Long id;
    private String vietnameseName;
    private String alterName;
    private String author;
    private BigInteger ISBNNumber;
    private Double import_price;
    private Date year_of_publication;
    private String publisher;
    private String language;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status;

    @ManyToOne(targetEntity = BookCategory.class)
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToOne(targetEntity = BookClassNumber.class)
    @JoinColumn(name = "classNumber_id")
    private BookCategory classNumber;

    @ManyToMany
    @JoinTable(
            name = "borrow_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "borrowedTicket_id")
    )
    List<BorrowedTicket> borrowedTickets;

//    public Book() {
//        this.borrowedTickets = new ArrayList<BorrowedTicket>();
//    }

//    public void addBorrowedTicket(BorrowedTicket newBorrowedTicket){
//        if(borrowedTickets == null){
//            this.borrowedTickets = new ArrayList<BorrowedTicket>();
//        }
//        borrowedTickets.add(newBorrowedTicket);
//    }
}

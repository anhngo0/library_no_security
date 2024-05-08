package com.example.libraryManagement.model.dto;

import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BorrowTicketDto implements Serializable {
    private Long id;
    private Date borrowed_date;
    private Date returned_date;
    private String member;
    private String librarian;
    private TicketStatus status;
}

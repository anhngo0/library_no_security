package com.example.libraryManagement.model.dto.form;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AcceptBorrowTicketForm {
    private LocalDateTime returned_date;
    private String note;
}

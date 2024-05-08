package com.example.libraryManagement.model.dto.form;

import lombok.Data;

import java.util.Date;

@Data
public class AcceptBorrowTicketForm {
    private Date returned_date;
    private String note;
}

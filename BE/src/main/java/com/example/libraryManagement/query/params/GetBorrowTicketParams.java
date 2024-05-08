package com.example.libraryManagement.query.params;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetBorrowTicketParams {
    private List<Long> listIds;
    private String keyword;
    private Date borrowed_from;
    private Date borrowed_to;
    private Date returned_from;
    private Date returned_to;
}

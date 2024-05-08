package com.example.libraryManagement.model.dto.form;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class CreateBorrowTicketForm {
    private Date borrowed_date;
    private Long memberId;
    private Long librarianId;
    private String note;
    private Set<Long> bookIds;
}

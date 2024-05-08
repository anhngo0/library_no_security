package com.example.libraryManagement.model.dto.form;

import lombok.Data;

import java.util.Date;

@Data
public class RespondImportTicketForm {
    private Date approval_date;
    private Long approverId;
    private String approver_note;
    private Boolean isAccepted;
}

package com.example.libraryManagement.model.dto.form;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RespondImportTicketForm {
    private LocalDateTime approval_date;
    private Long approverId;
    private String approver_note;
    private Boolean isAccepted;
}

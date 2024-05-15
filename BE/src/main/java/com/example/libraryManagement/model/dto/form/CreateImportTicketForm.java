package com.example.libraryManagement.model.dto.form;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
public class CreateImportTicketForm {
    private LocalDateTime created_date;
    private String creator_note;
    private Long creatorId;
    private Double totalPrice;
    private String import_way;
    private String supplier;
    private int totalQuantity;
}

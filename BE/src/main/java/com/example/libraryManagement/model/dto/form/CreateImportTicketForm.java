package com.example.libraryManagement.model.dto.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class CreateImportTicketForm {
    private Date created_date;
    private String creator_note;
    private Long creatorId;
    private Double export_price;
    private String import_way;
    private String supplier;
    private int totalQuantity;
}

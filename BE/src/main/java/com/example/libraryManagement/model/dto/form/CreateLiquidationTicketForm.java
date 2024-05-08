package com.example.libraryManagement.model.dto.form;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class CreateLiquidationTicketForm {
    private Date created_date;
    private String creator_note;
    private Long creatorId;
    private BigDecimal export_price;
    private int number;
    Set<Long> bookIds;
}

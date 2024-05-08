package com.example.libraryManagement.model.dto;

import com.example.libraryManagement.model.dto.form.ImportBookForm;
import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class ImportTicketDto implements Serializable {
    private Long id;
    private Date created_date;
    private Integer number;
    private Double totalPrice;
    private String creator_name;
    private TicketStatus status;
    private String import_way;
}

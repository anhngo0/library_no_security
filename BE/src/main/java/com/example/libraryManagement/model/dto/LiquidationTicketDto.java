package com.example.libraryManagement.model.dto;
import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class LiquidationTicketDto implements Serializable {
    private Long id;
    private Date created_date;
    private Integer number;
    private Double export_price;
    private String creator_name;
    private String approver_name;
    private TicketStatus status;
}

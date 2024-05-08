package com.example.libraryManagement.query.params;

import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class GetLiquidationTicketParams {
    private Long id;
    private String keyword;
    private Double exportPrice_from;
    private Double exportPrice_to;
    private Date create_from;
    private Date create_to;
    private Integer number_from;
    private Integer number_to;
}

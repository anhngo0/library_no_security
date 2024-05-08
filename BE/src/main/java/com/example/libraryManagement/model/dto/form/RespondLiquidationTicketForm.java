package com.example.libraryManagement.model.dto.form;

import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.util.Date;
@Data
public class RespondLiquidationTicketForm {
    private Date approval_date;
    private Long approverId;
    private Boolean isAccepted;

}

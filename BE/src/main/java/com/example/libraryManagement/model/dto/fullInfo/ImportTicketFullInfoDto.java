package com.example.libraryManagement.model.dto.fullInfo;

import com.example.libraryManagement.model.dto.FileStorageDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.entity.TicketStatus;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ImportTicketFullInfoDto implements Serializable {
    private Long id;
    private Date created_date;
    private Date approval_date;
    private String creator_note;
    private TicketStatus status;
    private ProfileMinInfoDto creator;
    private ProfileMinInfoDto approver;
    private Double totalPrice;
    private String import_way;
    private String supplier;
    private int number;
    List<FileStorageDto> attachments;
}

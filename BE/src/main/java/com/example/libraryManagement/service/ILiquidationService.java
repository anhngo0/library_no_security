package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.LiquidationTicketDto;
import com.example.libraryManagement.model.dto.form.CreateLiquidationTicketForm;
import com.example.libraryManagement.model.dto.form.RespondLiquidationTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.LiquidationTicketFullInfoDto;
import com.example.libraryManagement.query.params.GetLiquidationTicketParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ILiquidationService {
    LiquidationTicketDto createLiquidationTicket(CreateLiquidationTicketForm createLiquidationTicketForm, MultipartFile attachments);

    Page<LiquidationTicketDto> getLiquidationTickets(GetLiquidationTicketParams getLiquidationTicketParams, Pageable pageable);

    LiquidationTicketFullInfoDto getFullInfoById(Long id);

    LiquidationTicketDto updateLiquidationTicket(Long id, CreateLiquidationTicketForm createLiquidationTicketForm, MultipartFile attachments);

    void deleteLiquidationTicket(Long id);

    void respondLiquidationTicketForm(Long id,RespondLiquidationTicketForm respondLiquidationTicketForm);
}

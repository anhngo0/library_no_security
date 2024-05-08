package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.ImportTicketDto;
import com.example.libraryManagement.model.dto.form.CreateImportTicketForm;
import com.example.libraryManagement.model.dto.form.RespondImportTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.ImportTicketFullInfoDto;
import com.example.libraryManagement.query.params.GetImportTicketParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IImportTicketService {
    ImportTicketDto createImportTicket(CreateImportTicketForm createImportTicketForm, MultipartFile file);

    Page<ImportTicketDto> getImportTickets(GetImportTicketParams getImportTicketParams, Pageable pageable);

    ImportTicketFullInfoDto getImportTicketFullInfoById(Long id);

    ImportTicketDto updateImportTicket(Long id, CreateImportTicketForm createImportTicketForm, MultipartFile file);

    ImportTicketDto respondImportTicket(Long id, RespondImportTicketForm respondImportTicketForm);
}

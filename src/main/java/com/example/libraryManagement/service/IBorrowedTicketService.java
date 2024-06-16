package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.BorrowTicketDto;
import com.example.libraryManagement.model.dto.form.AcceptBorrowTicketForm;
import com.example.libraryManagement.model.dto.form.CreateBorrowTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.BorrowTicketFullInfoDto;
import com.example.libraryManagement.query.params.GetBorrowTicketParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowedTicketService {
    Page<BorrowTicketDto> getBorrowedTickets(GetBorrowTicketParams getBorrowTicketParams, Pageable pageable);

    BorrowTicketFullInfoDto getBorrowedTicketFullInfo(Long id);

    BorrowTicketDto updateBorrowedTicket(Long id, CreateBorrowTicketForm createBorrowTicketForm);

    void deleteBorrowedTicket(Long id);

    BorrowTicketDto respondBorrowedTicket(Long id, AcceptBorrowTicketForm acceptBorrowTicketForm);

    BorrowTicketDto createBorrowedTicket(CreateBorrowTicketForm createBorrowTicketForm);
}

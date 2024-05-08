package com.example.libraryManagement.service.serviceImpl;

import com.example.libraryManagement.exeption.ResourceNotFoundException;
import com.example.libraryManagement.mapper.ImportTicketMapper;
import com.example.libraryManagement.model.dto.ImportTicketDto;
import com.example.libraryManagement.model.dto.form.CreateImportTicketForm;
import com.example.libraryManagement.model.dto.form.RespondImportTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.ImportTicketFullInfoDto;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.entity.ImportTicket;
import com.example.libraryManagement.model.repository.ImportTicketRepository;
import com.example.libraryManagement.query.params.GetImportTicketParams;
import com.example.libraryManagement.query.predicate.ImportTicketPredicate;
import com.example.libraryManagement.service.IImportTicketService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ImportTicketServiceImpl implements IImportTicketService {
    private final ImportTicketRepository importTicketRepository;
    private final ImportTicketMapper importTicketMapper;
    private final FileStorageService fileStorageService;
    @Override
    public ImportTicketDto createImportTicket(CreateImportTicketForm createImportTicketForm, MultipartFile file) {
        ImportTicket importTicket = importTicketMapper.toEntity_create(createImportTicketForm);
        importTicket = importTicketRepository.save(importTicket);
        ImportTicket ticket = importTicket;
        CompletableFuture.runAsync(()-> {
            fileStorageService.uploadMultipleFiles(
                    ticket.getId(),
                    ImportTicket.class.getSimpleName(),
                    FileDescription.DOCUMENT,
                    file
            );
        });
        return importTicketMapper.toDto(ticket);
    }

    @Override
    public Page<ImportTicketDto> getImportTickets(GetImportTicketParams getImportTicketParams, Pageable pageable) {
        return importTicketRepository.findAll(ImportTicketPredicate.getImportTickets(getImportTicketParams), pageable)
                .map(importTicketMapper::toDto);
    }

    @Override
    public ImportTicketFullInfoDto getImportTicketFullInfoById(Long id) {
        ImportTicket importTicket = importTicketRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("resource not found"));
        return importTicketMapper.toFullInfoDto(importTicket);
    }

    @Override
    public ImportTicketDto updateImportTicket(Long id, CreateImportTicketForm createImportTicketForm, MultipartFile file) {
        ImportTicket importTicket = importTicketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
        importTicket=importTicketMapper.toEntity_update(createImportTicketForm, importTicket);
        importTicketRepository.save(importTicket);
        ImportTicket finalImportTicket = importTicket;
        if(file!=null){
           CompletableFuture.runAsync(()-> {
             fileStorageService.deleteAllFilesOfAnEntity(
                     ImportTicket.class.getSimpleName(),
                     finalImportTicket.getId(),
                     FileDescription.DOCUMENT
             );
             fileStorageService.uploadMultipleFiles(
                     finalImportTicket.getId(),
                     ImportTicket.class.getSimpleName(),
                     FileDescription.DOCUMENT,
                     file
             );
           });
       }
        return importTicketMapper.toDto(importTicket);
    }

    @Override
    public ImportTicketDto respondImportTicket(Long id, RespondImportTicketForm respondImportTicketForm) {
        ImportTicket importTicket = importTicketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
        importTicket = importTicketMapper.toEntity_response(respondImportTicketForm, importTicket);
        importTicket = importTicketRepository.save(importTicket);
        return importTicketMapper.toDto(importTicket);
    }
}

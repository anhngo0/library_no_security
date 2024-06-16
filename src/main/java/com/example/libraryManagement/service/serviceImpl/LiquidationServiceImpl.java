package com.example.libraryManagement.service.serviceImpl;

import com.example.libraryManagement.exeption.ResourceNotFoundException;
import com.example.libraryManagement.mapper.LiquidationMapper;
import com.example.libraryManagement.model.dto.LiquidationTicketDto;
import com.example.libraryManagement.model.dto.form.CreateLiquidationTicketForm;
import com.example.libraryManagement.model.dto.form.RespondLiquidationTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.LiquidationTicketFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookStatus;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.entity.LiquidationTicket;
import com.example.libraryManagement.model.repository.LiquidationRepository;
import com.example.libraryManagement.query.params.GetLiquidationTicketParams;
import com.example.libraryManagement.query.predicate.LiquidationPredicate;
import com.example.libraryManagement.service.IBookService;
import com.example.libraryManagement.service.ILiquidationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class LiquidationServiceImpl implements ILiquidationService {
    private final LiquidationRepository liquidationRepository;
    private final LiquidationMapper liquidationMapper;
    private final FileStorageService fileStorageService;
    private final Logger logger = LoggerFactory.getLogger(LiquidationServiceImpl.class);
    private final IBookService bookService;

    @Override
    public LiquidationTicketDto createLiquidationTicket(CreateLiquidationTicketForm createLiquidationTicketForm, MultipartFile attachments) {
        LiquidationTicket liquidationTicket = liquidationMapper.toEntity_create(createLiquidationTicketForm);
        liquidationTicket = liquidationRepository.save(liquidationTicket);
        LiquidationTicket newTicket = liquidationTicket;
        if(attachments != null ){
            CompletableFuture.runAsync(()-> {
                fileStorageService.uploadMultipleFiles(
                        newTicket.getId(),
                        LiquidationTicket.class.getSimpleName(),
                        FileDescription.DOCUMENT,
                        attachments
                );
            });
        }
        return liquidationMapper.toDto(liquidationTicket);
    }

    @Override
    public Page<LiquidationTicketDto> getLiquidationTickets(GetLiquidationTicketParams getLiquidationTicketParams, Pageable pageable) {
        return liquidationRepository
                .findAll(LiquidationPredicate.getLiquidationTickets(getLiquidationTicketParams),pageable)
                .map(liquidationMapper::toDto);
    }

    @Override
    public LiquidationTicketFullInfoDto getFullInfoById(Long id) {
        LiquidationTicket liquidationTicket = liquidationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("resource not found"));
        return liquidationMapper.toFullInfoDto(liquidationTicket);
    }

    @Override
    public LiquidationTicketDto updateLiquidationTicket(Long id, CreateLiquidationTicketForm createLiquidationTicketForm, MultipartFile attachments) {
        LiquidationTicket liquidationTicket = liquidationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("resource not found"));
        LiquidationTicket updateTicket = liquidationMapper.toEntity_update(createLiquidationTicketForm,liquidationTicket);
        updateTicket = liquidationRepository.save(updateTicket);

        if(attachments != null){
            CompletableFuture.runAsync(()->{
                fileStorageService.deleteAllFilesOfAnEntity(LiquidationTicket.class.getSimpleName(), id, FileDescription.DOCUMENT);
                fileStorageService.uploadMultipleFiles(
                        id,
                        LiquidationTicket.class.getSimpleName(),
                        FileDescription.DOCUMENT,
                        attachments
                );
            });
        }
        return liquidationMapper.toDto(updateTicket);
    }

    @Override
    public void deleteLiquidationTicket(Long id) throws ResourceNotFoundException {
        liquidationRepository.deleteById(id);
        fileStorageService.deleteAllFilesOfAnEntity(LiquidationTicket.class.getSimpleName(), id, FileDescription.DOCUMENT);
    }

    @Override
    public void respondLiquidationTicketForm(Long id,RespondLiquidationTicketForm respondLiquidationTicketForm) {
        LiquidationTicket liquidationTicket = liquidationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
        liquidationTicket = liquidationMapper.toEntity_response(respondLiquidationTicketForm,liquidationTicket);
        liquidationTicket = liquidationRepository.save(liquidationTicket);
        if (respondLiquidationTicketForm.getIsAccepted()) {
            bookService.setBookState(liquidationTicket.getBooks(), BookStatus.LIQUIDATED);
        }
    }

    @Override
    public void deleteMultiple(List<Long> ids) {
        try {
            liquidationRepository.deleteAllById(ids);
        } catch (RuntimeException e){
         logger.atInfo().log(e.getMessage());
        }
    }


}

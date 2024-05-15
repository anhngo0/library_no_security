package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.ImportTicketDto;
import com.example.libraryManagement.model.dto.form.CreateImportTicketForm;
import com.example.libraryManagement.model.dto.form.RespondImportTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.ImportTicketFullInfoDto;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.entity.ImportTicket;
import com.example.libraryManagement.model.entity.Ticket;
import com.example.libraryManagement.model.entity.TicketStatus;
import com.example.libraryManagement.service.serviceImpl.FileStorageService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {IdToEntityMapper.class}, imports = {FileDescription.class, TicketStatus.class})
public abstract class ImportTicketMapper {
    @Autowired
    protected FileStorageService fileStorageService;

    @Mapping(source = "creator.name", target = "creator_name")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ImportTicketDto toDto(ImportTicket importTicket);

    @Mapping(target = "attachments", expression = "java(fileStorageService.getAllFilesOfAnEntityWithoutData(importTicket.getClass().getSimpleName(), importTicket.getId(), FileDescription.DOCUMENT))")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract ImportTicketFullInfoDto toFullInfoDto(ImportTicket importTicket);

    @Mapping(source = "creatorId", target = "creator")
    @Mapping(target = "status", expression = "java(TicketStatus.PENDING)")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ImportTicket toEntity_create(CreateImportTicketForm createImportTicketForm);

    @Mapping(source = "creatorId", target = "creator")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ImportTicket toEntity_update(CreateImportTicketForm createImportTicketForm, @MappingTarget ImportTicket importTicket);

    @Mapping(source = "approverId", target = "approver")
    @Mapping(source = "isAccepted", target = "status", qualifiedByName = "setResponseStatus")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ImportTicket toEntity_response(RespondImportTicketForm respondImportTicketForm, @MappingTarget ImportTicket importTicket);

    @Named(value="setResponseStatus")
    protected TicketStatus setResponseStatus(Boolean isAccepted){
        return isAccepted ? TicketStatus.ACCEPT:TicketStatus.REJECT;
    }
}

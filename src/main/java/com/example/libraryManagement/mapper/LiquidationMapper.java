package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.LiquidationTicketDto;
import com.example.libraryManagement.model.dto.form.CreateLiquidationTicketForm;
import com.example.libraryManagement.model.dto.form.RespondLiquidationTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.LiquidationTicketFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.entity.LiquidationTicket;
import com.example.libraryManagement.model.entity.TicketStatus;
import com.example.libraryManagement.service.serviceImpl.FileStorageService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        IdToEntityMapper.class
}, imports = {TicketStatus.class, FileDescription.class})
public abstract class LiquidationMapper {
    @Autowired
    protected FileStorageService fileStorageService;

    @Mapping(source = "creator.name", target = "creator_name")
    @Mapping(source = "approver.name", target = "approver_name")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract LiquidationTicketDto toDto(LiquidationTicket liquidationTicket);

    @Mapping(target = "attachments", expression = "java(fileStorageService.getAllFilesOfAnEntityWithoutData(liquidationTicket.getClass().getSimpleName(), liquidationTicket.getId(), FileDescription.DOCUMENT))")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract LiquidationTicketFullInfoDto toFullInfoDto(LiquidationTicket liquidationTicket);

    @Mapping(source = "creatorId", target = "creator")
    @Mapping(source = "bookIds", target = "books")
    @Mapping(target = "status", expression = "java(TicketStatus.PENDING)")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract LiquidationTicket toEntity_create(CreateLiquidationTicketForm createLiquidationTicketForm);

    @Mapping(source = "approverId", target = "approver")
    @Mapping(source = "isAccepted", target = "status", qualifiedByName = "setResponseStatus")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract LiquidationTicket toEntity_response(RespondLiquidationTicketForm respondLiquidationTicketForm, @MappingTarget LiquidationTicket liquidationTicket);

    @Mapping(source = "creatorId", target = "creator")
    @Mapping(source = "bookIds", target = "books")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract LiquidationTicket toEntity_update(CreateLiquidationTicketForm createLiquidationTicketForm, @MappingTarget LiquidationTicket liquidationTicket);

    @Named(value="setResponseStatus")
    protected TicketStatus setResponseStatus(Boolean isAccepted){
        return isAccepted ? TicketStatus.ACCEPT:TicketStatus.REJECT;
    }


}

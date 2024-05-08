package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.ImportTicketDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.CreateImportTicketForm;
import com.example.libraryManagement.model.dto.form.RespondImportTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.ImportTicketFullInfoDto;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.entity.ImportTicket;
import com.example.libraryManagement.model.entity.Profile;
import com.example.libraryManagement.model.entity.TicketStatus;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T10:54:05+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ImportTicketMapperImpl extends ImportTicketMapper {

    @Autowired
    private IdToEntityMapper idToEntityMapper;

    @Override
    public ImportTicketDto toDto(ImportTicket importTicket) {
        if ( importTicket == null ) {
            return null;
        }

        ImportTicketDto importTicketDto = new ImportTicketDto();

        importTicketDto.setCreator_name( importTicketCreatorName( importTicket ) );
        importTicketDto.setId( importTicket.getId() );
        importTicketDto.setCreated_date( importTicket.getCreated_date() );
        importTicketDto.setTotalPrice( importTicket.getTotalPrice() );
        importTicketDto.setStatus( importTicket.getStatus() );
        importTicketDto.setImport_way( importTicket.getImport_way() );

        return importTicketDto;
    }

    @Override
    public ImportTicketFullInfoDto toFullInfoDto(ImportTicket importTicket) {
        if ( importTicket == null ) {
            return null;
        }

        ImportTicketFullInfoDto importTicketFullInfoDto = new ImportTicketFullInfoDto();

        importTicketFullInfoDto.setId( importTicket.getId() );
        importTicketFullInfoDto.setCreated_date( importTicket.getCreated_date() );
        importTicketFullInfoDto.setApproval_date( importTicket.getApproval_date() );
        importTicketFullInfoDto.setCreator_note( importTicket.getCreator_note() );
        importTicketFullInfoDto.setStatus( importTicket.getStatus() );
        importTicketFullInfoDto.setCreator( profileToProfileMinInfoDto( importTicket.getCreator() ) );
        importTicketFullInfoDto.setApprover( profileToProfileMinInfoDto( importTicket.getApprover() ) );
        importTicketFullInfoDto.setTotalPrice( importTicket.getTotalPrice() );
        importTicketFullInfoDto.setImport_way( importTicket.getImport_way() );
        importTicketFullInfoDto.setSupplier( importTicket.getSupplier() );

        importTicketFullInfoDto.setAttachments( fileStorageService.getAllFilesOfAnEntityWithoutData(importTicket.getClass().getSimpleName(), importTicket.getId(), FileDescription.DOCUMENT) );

        return importTicketFullInfoDto;
    }

    @Override
    public ImportTicket toEntity_create(CreateImportTicketForm createImportTicketForm) {
        if ( createImportTicketForm == null ) {
            return null;
        }

        ImportTicket importTicket = new ImportTicket();

        importTicket.setCreator( idToEntityMapper.toProfile( createImportTicketForm.getCreatorId() ) );
        importTicket.setCreated_date( createImportTicketForm.getCreated_date() );
        importTicket.setCreator_note( createImportTicketForm.getCreator_note() );
        importTicket.setSupplier( createImportTicketForm.getSupplier() );
        importTicket.setImport_way( createImportTicketForm.getImport_way() );

        importTicket.setStatus( TicketStatus.PENDING );

        return importTicket;
    }

    @Override
    public ImportTicket toEntity_update(CreateImportTicketForm createImportTicketForm, ImportTicket importTicket) {
        if ( createImportTicketForm == null ) {
            return importTicket;
        }

        importTicket.setCreator( idToEntityMapper.toProfile( createImportTicketForm.getCreatorId() ) );
        importTicket.setCreated_date( createImportTicketForm.getCreated_date() );
        importTicket.setCreator_note( createImportTicketForm.getCreator_note() );
        importTicket.setSupplier( createImportTicketForm.getSupplier() );
        importTicket.setImport_way( createImportTicketForm.getImport_way() );

        return importTicket;
    }

    @Override
    public ImportTicket toEntity_response(RespondImportTicketForm respondImportTicketForm, ImportTicket importTicket) {
        if ( respondImportTicketForm == null ) {
            return importTicket;
        }

        importTicket.setCreator( idToEntityMapper.toProfile( respondImportTicketForm.getApproverId() ) );
        importTicket.setStatus( setResponseStatus( respondImportTicketForm.getIsAccepted() ) );
        importTicket.setApproval_date( respondImportTicketForm.getApproval_date() );

        return importTicket;
    }

    private String importTicketCreatorName(ImportTicket importTicket) {
        if ( importTicket == null ) {
            return null;
        }
        Profile creator = importTicket.getCreator();
        if ( creator == null ) {
            return null;
        }
        String name = creator.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected ProfileMinInfoDto profileToProfileMinInfoDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileMinInfoDto profileMinInfoDto = new ProfileMinInfoDto();

        profileMinInfoDto.setId( profile.getId() );
        profileMinInfoDto.setName( profile.getName() );
        profileMinInfoDto.setPhone( profile.getPhone() );
        profileMinInfoDto.setEmail( profile.getEmail() );

        return profileMinInfoDto;
    }
}

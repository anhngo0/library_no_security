package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.LiquidationTicketDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.CreateLiquidationTicketForm;
import com.example.libraryManagement.model.dto.form.RespondLiquidationTicketForm;
import com.example.libraryManagement.model.dto.fullInfo.LiquidationTicketFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.FileDescription;
import com.example.libraryManagement.model.entity.LiquidationTicket;
import com.example.libraryManagement.model.entity.Profile;
import com.example.libraryManagement.model.entity.TicketStatus;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T00:26:50+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class LiquidationMapperImpl extends LiquidationMapper {

    @Autowired
    private IdToEntityMapper idToEntityMapper;

    @Override
    public LiquidationTicketDto toDto(LiquidationTicket liquidationTicket) {
        if ( liquidationTicket == null ) {
            return null;
        }

        LiquidationTicketDto liquidationTicketDto = new LiquidationTicketDto();

        liquidationTicketDto.setCreator_name( liquidationTicketCreatorName( liquidationTicket ) );
        liquidationTicketDto.setApprover_name( liquidationTicketApproverName( liquidationTicket ) );
        liquidationTicketDto.setId( liquidationTicket.getId() );
        liquidationTicketDto.setCreated_date( liquidationTicket.getCreated_date() );
        liquidationTicketDto.setExport_price( liquidationTicket.getExport_price() );
        liquidationTicketDto.setTotalQuantity( liquidationTicket.getTotalQuantity() );
        liquidationTicketDto.setStatus( liquidationTicket.getStatus() );

        return liquidationTicketDto;
    }

    @Override
    public LiquidationTicketFullInfoDto toFullInfoDto(LiquidationTicket liquidationTicket) {
        if ( liquidationTicket == null ) {
            return null;
        }

        LiquidationTicketFullInfoDto liquidationTicketFullInfoDto = new LiquidationTicketFullInfoDto();

        liquidationTicketFullInfoDto.setId( liquidationTicket.getId() );
        liquidationTicketFullInfoDto.setCreated_date( liquidationTicket.getCreated_date() );
        liquidationTicketFullInfoDto.setApproval_date( liquidationTicket.getApproval_date() );
        liquidationTicketFullInfoDto.setCreator_note( liquidationTicket.getCreator_note() );
        liquidationTicketFullInfoDto.setApprover_note( liquidationTicket.getApprover_note() );
        liquidationTicketFullInfoDto.setStatus( liquidationTicket.getStatus() );
        liquidationTicketFullInfoDto.setCreator( profileToProfileMinInfoDto( liquidationTicket.getCreator() ) );
        liquidationTicketFullInfoDto.setApprover( profileToProfileMinInfoDto( liquidationTicket.getApprover() ) );
        liquidationTicketFullInfoDto.setExport_price( liquidationTicket.getExport_price() );
        liquidationTicketFullInfoDto.setTotalQuantity( liquidationTicket.getTotalQuantity() );

        liquidationTicketFullInfoDto.setAttachments( fileStorageService.getAllFilesOfAnEntityWithoutData(liquidationTicket.getClass().getSimpleName(), liquidationTicket.getId(), FileDescription.DOCUMENT) );

        return liquidationTicketFullInfoDto;
    }

    @Override
    public LiquidationTicket toEntity_create(CreateLiquidationTicketForm createLiquidationTicketForm) {
        if ( createLiquidationTicketForm == null ) {
            return null;
        }

        LiquidationTicket liquidationTicket = new LiquidationTicket();

        liquidationTicket.setCreator( idToEntityMapper.toProfile( createLiquidationTicketForm.getCreatorId() ) );
        liquidationTicket.setBooks( idToEntityMapper.toBooks( createLiquidationTicketForm.getBookIds() ) );
        liquidationTicket.setCreated_date( createLiquidationTicketForm.getCreated_date() );
        liquidationTicket.setCreator_note( createLiquidationTicketForm.getCreator_note() );
        if ( createLiquidationTicketForm.getExport_price() != null ) {
            liquidationTicket.setExport_price( createLiquidationTicketForm.getExport_price().doubleValue() );
        }
        if ( createLiquidationTicketForm.getTotalQuantity() != null ) {
            liquidationTicket.setTotalQuantity( createLiquidationTicketForm.getTotalQuantity() );
        }

        liquidationTicket.setStatus( TicketStatus.PENDING );

        return liquidationTicket;
    }

    @Override
    public LiquidationTicket toEntity_response(RespondLiquidationTicketForm respondLiquidationTicketForm, LiquidationTicket liquidationTicket) {
        if ( respondLiquidationTicketForm == null ) {
            return liquidationTicket;
        }

        liquidationTicket.setApprover( idToEntityMapper.toProfile( respondLiquidationTicketForm.getApproverId() ) );
        liquidationTicket.setStatus( setResponseStatus( respondLiquidationTicketForm.getIsAccepted() ) );
        liquidationTicket.setApproval_date( respondLiquidationTicketForm.getApproval_date() );
        liquidationTicket.setApprover_note( respondLiquidationTicketForm.getApprover_note() );

        return liquidationTicket;
    }

    @Override
    public LiquidationTicket toEntity_update(CreateLiquidationTicketForm createLiquidationTicketForm, LiquidationTicket liquidationTicket) {
        if ( createLiquidationTicketForm == null ) {
            return liquidationTicket;
        }

        liquidationTicket.setCreator( idToEntityMapper.toProfile( createLiquidationTicketForm.getCreatorId() ) );
        if ( liquidationTicket.getBooks() != null ) {
            Set<Book> set = idToEntityMapper.toBooks( createLiquidationTicketForm.getBookIds() );
            if ( set != null ) {
                liquidationTicket.getBooks().clear();
                liquidationTicket.getBooks().addAll( set );
            }
            else {
                liquidationTicket.setBooks( null );
            }
        }
        else {
            Set<Book> set = idToEntityMapper.toBooks( createLiquidationTicketForm.getBookIds() );
            if ( set != null ) {
                liquidationTicket.setBooks( set );
            }
        }
        liquidationTicket.setCreated_date( createLiquidationTicketForm.getCreated_date() );
        liquidationTicket.setCreator_note( createLiquidationTicketForm.getCreator_note() );
        if ( createLiquidationTicketForm.getExport_price() != null ) {
            liquidationTicket.setExport_price( createLiquidationTicketForm.getExport_price().doubleValue() );
        }
        else {
            liquidationTicket.setExport_price( null );
        }
        if ( createLiquidationTicketForm.getTotalQuantity() != null ) {
            liquidationTicket.setTotalQuantity( createLiquidationTicketForm.getTotalQuantity() );
        }

        return liquidationTicket;
    }

    private String liquidationTicketCreatorName(LiquidationTicket liquidationTicket) {
        if ( liquidationTicket == null ) {
            return null;
        }
        Profile creator = liquidationTicket.getCreator();
        if ( creator == null ) {
            return null;
        }
        String name = creator.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String liquidationTicketApproverName(LiquidationTicket liquidationTicket) {
        if ( liquidationTicket == null ) {
            return null;
        }
        Profile approver = liquidationTicket.getApprover();
        if ( approver == null ) {
            return null;
        }
        String name = approver.getName();
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

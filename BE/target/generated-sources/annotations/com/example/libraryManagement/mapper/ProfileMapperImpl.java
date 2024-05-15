package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.UpsertProfileForm;
import com.example.libraryManagement.model.dto.fullInfo.ProfileFullInfoDto;
import com.example.libraryManagement.model.entity.Profile;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T01:32:48+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProfileMapperImpl extends ProfileMapper {

    @Override
    public ProfileFullInfoDto toFullInfoDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileFullInfoDto profileFullInfoDto = new ProfileFullInfoDto();

        profileFullInfoDto.setId( profile.getId() );
        profileFullInfoDto.setName( profile.getName() );
        if ( profile.getDoB() != null ) {
            profileFullInfoDto.setDoB( Date.from( profile.getDoB().toInstant( ZoneOffset.UTC ) ) );
        }
        profileFullInfoDto.setCCCD_ID( profile.getCCCD_ID() );
        profileFullInfoDto.setAddress( profile.getAddress() );
        profileFullInfoDto.setPhone( profile.getPhone() );
        profileFullInfoDto.setEmail( profile.getEmail() );

        return profileFullInfoDto;
    }

    @Override
    public ProfileMinInfoDto toMinInfoDto(Profile profile) {
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

    @Override
    public Profile toEntity(UpsertProfileForm upsertProfileForm) {
        if ( upsertProfileForm == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setName( upsertProfileForm.getName() );
        if ( upsertProfileForm.getDoB() != null ) {
            profile.setDoB( LocalDateTime.ofInstant( upsertProfileForm.getDoB().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        profile.setCCCD_ID( upsertProfileForm.getCCCD_ID() );
        profile.setAddress( upsertProfileForm.getAddress() );
        profile.setPhone( upsertProfileForm.getPhone() );
        profile.setEmail( upsertProfileForm.getEmail() );

        return profile;
    }

    @Override
    public Profile toEntity_update(UpsertProfileForm upsertProfileForm, Profile profile) {
        if ( upsertProfileForm == null ) {
            return profile;
        }

        if ( upsertProfileForm.getName() != null ) {
            profile.setName( upsertProfileForm.getName() );
        }
        if ( upsertProfileForm.getDoB() != null ) {
            profile.setDoB( LocalDateTime.ofInstant( upsertProfileForm.getDoB().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        if ( upsertProfileForm.getCCCD_ID() != null ) {
            profile.setCCCD_ID( upsertProfileForm.getCCCD_ID() );
        }
        if ( upsertProfileForm.getAddress() != null ) {
            profile.setAddress( upsertProfileForm.getAddress() );
        }
        if ( upsertProfileForm.getPhone() != null ) {
            profile.setPhone( upsertProfileForm.getPhone() );
        }
        if ( upsertProfileForm.getEmail() != null ) {
            profile.setEmail( upsertProfileForm.getEmail() );
        }

        return profile;
    }
}

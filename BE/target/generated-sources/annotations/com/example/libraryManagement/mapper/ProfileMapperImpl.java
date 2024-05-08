package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.UpsertProfileForm;
import com.example.libraryManagement.model.dto.fullInfo.ProfileFullInfoDto;
import com.example.libraryManagement.model.entity.Profile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T15:31:29+0700",
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
        profileFullInfoDto.setDoB( profile.getDoB() );
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
        profile.setDoB( upsertProfileForm.getDoB() );
        profile.setCCCD_ID(upsertProfileForm.getCCCD_ID() );
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
            profile.setDoB( upsertProfileForm.getDoB() );
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

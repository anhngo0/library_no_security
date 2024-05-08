package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.fullInfo.ProfileFullInfoDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.form.UpsertProfileForm;
import com.example.libraryManagement.model.entity.Profile;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public abstract class ProfileMapper {
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract ProfileFullInfoDto toFullInfoDto(Profile profile);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract ProfileMinInfoDto toMinInfoDto(Profile profile);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Profile toEntity(UpsertProfileForm upsertProfileForm);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Profile toEntity_update(UpsertProfileForm upsertProfileForm, @MappingTarget Profile profile);

}

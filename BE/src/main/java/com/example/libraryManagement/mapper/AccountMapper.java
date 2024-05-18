package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.AccountDto;
import com.example.libraryManagement.model.dto.form.UpsertAccountForm;
import com.example.libraryManagement.model.dto.form.UpsertRoleForm;
import com.example.libraryManagement.model.dto.fullInfo.AccountFullInfoDto;
import com.example.libraryManagement.model.entity.Account;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = { IdToEntityMapper.class})
public abstract class AccountMapper {

    @Mapping(source = "role.name", target="roleName")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract AccountDto toDto(Account account);

    public abstract AccountFullInfoDto toFullInfoDto(Account account);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "profileId", target = "profile")
    @Mapping(source = "roleId", target = "role")
    public abstract Account toEntity(UpsertAccountForm upsertAccountForm);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "profileId", target = "profile")
    @Mapping(source = "roleId", target = "role")
    public abstract Account toEntity_update(UpsertAccountForm upsertAccountForm, @MappingTarget Account account);
}

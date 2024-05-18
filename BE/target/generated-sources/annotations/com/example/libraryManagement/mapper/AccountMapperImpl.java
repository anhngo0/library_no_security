package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.AccountDto;
import com.example.libraryManagement.model.dto.PermissionDto;
import com.example.libraryManagement.model.dto.ProfileMinInfoDto;
import com.example.libraryManagement.model.dto.RoleDto;
import com.example.libraryManagement.model.dto.form.UpsertAccountForm;
import com.example.libraryManagement.model.dto.fullInfo.AccountFullInfoDto;
import com.example.libraryManagement.model.dto.fullInfo.ProfileFullInfoDto;
import com.example.libraryManagement.model.entity.Account;
import com.example.libraryManagement.model.entity.Permission;
import com.example.libraryManagement.model.entity.Profile;
import com.example.libraryManagement.model.entity.Role;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-17T09:53:12+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl extends AccountMapper {

    @Autowired
    private IdToEntityMapper idToEntityMapper;

    @Override
    public AccountDto toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setRoleName( accountRoleName( account ) );
        accountDto.setId( account.getId() );
        accountDto.setUsername( account.getUsername() );
        accountDto.setProfile( profileToProfileMinInfoDto( account.getProfile() ) );

        return accountDto;
    }

    @Override
    public AccountFullInfoDto toFullInfoDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountFullInfoDto accountFullInfoDto = new AccountFullInfoDto();

        accountFullInfoDto.setId( account.getId() );
        accountFullInfoDto.setUsername( account.getUsername() );
        accountFullInfoDto.setPassword( account.getPassword() );
        accountFullInfoDto.setProfile( profileToProfileFullInfoDto( account.getProfile() ) );
        accountFullInfoDto.setRole( roleToRoleDto( account.getRole() ) );

        return accountFullInfoDto;
    }

    @Override
    public Account toEntity(UpsertAccountForm upsertAccountForm) {
        if ( upsertAccountForm == null ) {
            return null;
        }

        Account account = new Account();

        account.setProfile( idToEntityMapper.toProfile( upsertAccountForm.getProfileId() ) );
        account.setRole( idToEntityMapper.toRole( upsertAccountForm.getRoleId() ) );
        account.setUsername( upsertAccountForm.getUsername() );
        account.setPassword( upsertAccountForm.getPassword() );

        return account;
    }

    @Override
    public Account toEntity_update(UpsertAccountForm upsertAccountForm, Account account) {
        if ( upsertAccountForm == null ) {
            return account;
        }

        account.setProfile( idToEntityMapper.toProfile( upsertAccountForm.getProfileId() ) );
        account.setRole( idToEntityMapper.toRole( upsertAccountForm.getRoleId() ) );
        account.setUsername( upsertAccountForm.getUsername() );
        account.setPassword( upsertAccountForm.getPassword() );

        return account;
    }

    private String accountRoleName(Account account) {
        if ( account == null ) {
            return null;
        }
        Role role = account.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
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

    protected ProfileFullInfoDto profileToProfileFullInfoDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileFullInfoDto profileFullInfoDto = new ProfileFullInfoDto();

        profileFullInfoDto.setId( profile.getId() );
        profileFullInfoDto.setName( profile.getName() );
        if ( profile.getDoB() != null ) {
            profileFullInfoDto.setDoB( Date.from( profile.getDoB().toInstant( ZoneOffset.UTC ) ) );
        }
        profileFullInfoDto.setCccd_Id( profile.getCccd_Id() );
        profileFullInfoDto.setAddress( profile.getAddress() );
        profileFullInfoDto.setPhone( profile.getPhone() );
        profileFullInfoDto.setEmail( profile.getEmail() );
        profileFullInfoDto.setUserRole( profile.getUserRole() );

        return profileFullInfoDto;
    }

    protected PermissionDto permissionToPermissionDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.setId( permission.getId() );
        permissionDto.setName( permission.getName() );
        permissionDto.setDescription( permission.getDescription() );

        return permissionDto;
    }

    protected Set<PermissionDto> permissionSetToPermissionDtoSet(Set<Permission> set) {
        if ( set == null ) {
            return null;
        }

        Set<PermissionDto> set1 = new LinkedHashSet<PermissionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Permission permission : set ) {
            set1.add( permissionToPermissionDto( permission ) );
        }

        return set1;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );
        roleDto.setDescription( role.getDescription() );
        roleDto.setPermissions( permissionSetToPermissionDtoSet( role.getPermissions() ) );

        return roleDto;
    }
}

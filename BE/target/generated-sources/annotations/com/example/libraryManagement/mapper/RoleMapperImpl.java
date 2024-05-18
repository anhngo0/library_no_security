package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.PermissionDto;
import com.example.libraryManagement.model.dto.RoleDto;
import com.example.libraryManagement.model.dto.form.UpsertRoleForm;
import com.example.libraryManagement.model.entity.Permission;
import com.example.libraryManagement.model.entity.Role;
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
public class RoleMapperImpl extends RoleMapper {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Role toEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );
        role.setDescription( roleDto.getDescription() );
        role.setPermissions( permissionDtoSetToPermissionSet( roleDto.getPermissions() ) );

        return role;
    }

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setPermissions( permissionSetToPermissionDtoSet( role.getPermissions() ) );
        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );
        roleDto.setDescription( role.getDescription() );

        return roleDto;
    }

    @Override
    public Role toEntity(UpsertRoleForm upsertRoleForm) {
        if ( upsertRoleForm == null ) {
            return null;
        }

        Role role = new Role();

        role.setPermissions( permissionStringToPermissionEntity( upsertRoleForm.getPermissions() ) );
        role.setName( upsertRoleForm.getName() );
        role.setDescription( upsertRoleForm.getDescription() );

        return role;
    }

    @Override
    public Role toEntity_update(UpsertRoleForm upsertRoleForm, Role role) {
        if ( upsertRoleForm == null ) {
            return role;
        }

        if ( role.getPermissions() != null ) {
            Set<Permission> set = permissionStringToPermissionEntity( upsertRoleForm.getPermissions() );
            if ( set != null ) {
                role.getPermissions().clear();
                role.getPermissions().addAll( set );
            }
        }
        else {
            Set<Permission> set = permissionStringToPermissionEntity( upsertRoleForm.getPermissions() );
            if ( set != null ) {
                role.setPermissions( set );
            }
        }
        if ( upsertRoleForm.getName() != null ) {
            role.setName( upsertRoleForm.getName() );
        }
        if ( upsertRoleForm.getDescription() != null ) {
            role.setDescription( upsertRoleForm.getDescription() );
        }

        return role;
    }

    protected Set<Permission> permissionDtoSetToPermissionSet(Set<PermissionDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Permission> set1 = new LinkedHashSet<Permission>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PermissionDto permissionDto : set ) {
            set1.add( permissionMapper.toEntity( permissionDto ) );
        }

        return set1;
    }

    protected Set<PermissionDto> permissionSetToPermissionDtoSet(Set<Permission> set) {
        if ( set == null ) {
            return null;
        }

        Set<PermissionDto> set1 = new LinkedHashSet<PermissionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Permission permission : set ) {
            set1.add( permissionMapper.toDto( permission ) );
        }

        return set1;
    }
}

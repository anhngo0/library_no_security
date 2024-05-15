package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.PermissionDto;
import com.example.libraryManagement.model.entity.Permission;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T01:32:48+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PermissionMapperImpl extends PermissionMapper {

    @Override
    public Permission toEntity(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setId( permissionDto.getId() );
        permission.setName( permissionDto.getName() );
        permission.setDescription( permissionDto.getDescription() );

        return permission;
    }

    @Override
    public PermissionDto toDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.setId( permission.getId() );
        permissionDto.setName( permission.getName() );
        permissionDto.setDescription( permission.getDescription() );

        return permissionDto;
    }
}

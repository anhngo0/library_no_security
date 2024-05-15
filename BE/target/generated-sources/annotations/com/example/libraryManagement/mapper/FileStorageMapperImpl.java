package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.FileStorageDto;
import com.example.libraryManagement.model.entity.FileStorage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T01:32:48+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FileStorageMapperImpl extends FileStorageMapper {

    @Override
    public FileStorageDto toDto(FileStorage file) {
        if ( file == null ) {
            return null;
        }

        FileStorageDto fileStorageDto = new FileStorageDto();

        fileStorageDto.setId( file.getId() );
        fileStorageDto.setName( file.getName() );
        fileStorageDto.setContentType( file.getContentType() );
        fileStorageDto.setExtension( file.getExtension() );
        fileStorageDto.setAssociatedEntityId( file.getAssociatedEntityId() );
        fileStorageDto.setAssociatedEntityType( file.getAssociatedEntityType() );
        fileStorageDto.setDescription( file.getDescription() );

        return fileStorageDto;
    }
}

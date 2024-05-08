package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.model.dto.fullInfo.BookFullInfoDto;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.BookStatus;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING, uses = {
                IdToEntityMapper.class,LiquidationMapper.class
}, imports = {BookStatus.class}
)
public abstract class BookMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract BookDto toDto(Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract BookFullInfoDto toFullInfoDto(Book book);

    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "classNumberId", target = "classNumber")
    @Mapping(target = "status", expression = "java(BookStatus.IN_USE_NEW)")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Book toEntity(UpsertBookForm upsertBookForm);

    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "classNumberId", target = "classNumber")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Book toEntity_updateBook(@MappingTarget Book book,  UpsertBookForm upsertBookForm);
}

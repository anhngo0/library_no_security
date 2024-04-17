package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookDto;
import com.example.libraryManagement.model.dto.form.UpsertBookForm;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookCategory;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING, uses = {
                IdToEntityMapper.class
}
)
public abstract class BookMapper {
    @Mapping(source = "category.id",target = "categoryId")
    @Mapping(source = "classNumber.id", target = "classNumberId")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract BookDto toDto(Book book);

    @Mapping(source = "upsertBookForm.categoryId", target = "category")
    @Mapping(source = "upsertBookForm.classNumberId", target = "classNumber")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract Book toEntity(UpsertBookForm upsertBookForm);

    @Mapping(source = "upsertBookForm.categoryId", target = "category")
    @Mapping(source = "upsertBookForm.classNumberId", target = "classNumber")
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Book toEntity_updateBook(@MappingTarget Book book,  UpsertBookForm upsertBookForm);
}

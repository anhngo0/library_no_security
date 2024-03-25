package com.example.libraryManagement.mapper;

import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.entity.BookCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.awt.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface  BookCategoryMapper {
    public  BookCategoryDto toDto(BookCategory bookCategory);
    public BookCategory toEntity(BookCategoryDto bookCategoryDto);
    @Mapping(target = "id", ignore = true)
    public abstract BookCategory toEntity(UpsertBookCategoryForm upsertBookCategoryForm);
}

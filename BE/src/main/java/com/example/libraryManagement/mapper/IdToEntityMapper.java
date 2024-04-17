package com.example.libraryManagement.mapper;

import com.example.libraryManagement.exeption.ResourceNotFoundException;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.BookClassNumber;
import com.example.libraryManagement.model.repository.BookCategoryRepository;
import com.example.libraryManagement.model.repository.BookClassNumberRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class IdToEntityMapper {
    @Autowired
    protected BookCategoryRepository bookCategoryRepository;

    @Autowired
    protected  BookClassNumberRepository bookClassNumberRepository;

    public BookCategory toCategory(Long categoryId){
        return !ObjectUtils.isEmpty(categoryId) ?
                bookCategoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("resource not found"))
                : null;
    }

    public BookClassNumber toClassNumber(Long bookClassNumberId){
        return !ObjectUtils.isEmpty(bookClassNumberId) ?
                bookClassNumberRepository.findById(bookClassNumberId).orElseThrow(() -> new ResourceNotFoundException("resource not found"))
                :null;
    }
}

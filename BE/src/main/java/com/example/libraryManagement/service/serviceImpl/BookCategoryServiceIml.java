package com.example.libraryManagement.service.serviceImpl;

import com.example.libraryManagement.exeption.ResourceNotFoundException;
import com.example.libraryManagement.mapper.BookCategoryMapper;
import com.example.libraryManagement.model.dto.BookCategoryDto;
import com.example.libraryManagement.model.dto.form.UpsertBookCategoryForm;
import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.repository.BookCategoryRepository;
import com.example.libraryManagement.service.IBookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCategoryServiceIml implements IBookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;
    private final BookCategoryMapper bookCategoryMapper;
    public List<BookCategoryDto> getAllBookCategories(){
        List<BookCategory> bookCategoryList = bookCategoryRepository.findAll();
        List<BookCategoryDto> bookCategoryDtoList = new ArrayList<BookCategoryDto>();
        for(BookCategory bookCategory : bookCategoryList){
            bookCategoryDtoList.add(bookCategoryMapper.toDto(bookCategory));
        }
        return bookCategoryDtoList;
    }

    @Override
    public BookCategoryDto getBookCategoryById(Long id) {
        BookCategory bookCategory = bookCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can not found book category which id is "+ id));
        return bookCategoryMapper.toDto(bookCategory);
    }

    @Override
    public BookCategoryDto createBookCategory(UpsertBookCategoryForm upsertBookCategoryForm) {
        BookCategory bookCategory = bookCategoryMapper.toEntity(upsertBookCategoryForm);
        bookCategory = bookCategoryRepository.save(bookCategory);
        return bookCategoryMapper.toDto(bookCategory);
    }

//    @Override
//    public BookCategoryDto updateBookCategory(String name) {
//        BookCategory bookCategory = bookCategoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Can not found book category which id is "+ id));
//        return null;
//    }
}

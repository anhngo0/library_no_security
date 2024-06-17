//package com.example.libraryManagement.service.serviceImpl;
//
//import com.example.libraryManagement.mapper.BookCategoryMapper;
//import com.example.libraryManagement.model.repository.BookCategoryRepository;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.mockito.Mockito.verify;
//
//@Transactional
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class BookCategoryServiceImplTest {
//
//    @InjectMocks
//    private BookCategoryServiceImpl serviceTest;
//    @Mock
//    private BookCategoryRepository repository;
//    @Mock
//    private BookCategoryMapper mapper;
//    @BeforeEach
//    void init(){
//    }
////    @Test
////    void getBookCategories() {
////        serviceTest.getBookCategories(new GetBookCategoriesQueryParams(""), PageRequest.of(0,10));
////        verify(repository).findAll();
////    }
//
//    @Test
//    @Disabled
//    void getBookCategoryById() {
//    }
//
//    @Test
//    @Disabled
//    void createBookCategory() {
//    }
//
//    @Test
//    @Disabled
//    void updateBookCategory() {
//    }
//
//    @Test
//    @Disabled
//    void deleteBookCategory() {
//    }
//}
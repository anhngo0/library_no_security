//package com.example.libraryManagement.service.serviceImpl;
//
//import com.example.libraryManagement.mapper.BookMapper;
//import com.example.libraryManagement.mapper.LiquidationMapper;
//import com.example.libraryManagement.mapper.ProfileMapper;
//import com.example.libraryManagement.model.dto.BookDto;
//import com.example.libraryManagement.model.dto.LiquidationDto;
//import com.example.libraryManagement.model.dto.form.CreateLiquidationTicketForm;
//import com.example.libraryManagement.model.dto.fullInfo.LiquidationFullInfoDto;
//import com.example.libraryManagement.model.entity.*;
//import com.mysema.commons.lang.Assert;
//import jakarta.transaction.Transactional;
//import org.apache.tomcat.util.json.JSONParser;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//
//@Transactional
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//public class LiquidationServiceTest {
//
//    @Autowired
//    LiquidationMapper liquidationMapper;
//
//    @Autowired
//    ProfileMapper profileMapper;
//
//    @Autowired
//    BookMapper bookMapper;
//
//    void init(){}
//
//    @Test
//    void testLiquidationMapper(){
//        Profile creator = new Profile();
//        creator.setName("creator_1");
//        creator.setEmail("creator@gmail.com");
//        creator.setPhone("0929929292");
//        creator.setCCCD_ID("1232765423");
//
//        Profile approver = new Profile();
//        approver.setName("approver_1");
//        approver.setEmail("approver@gmail.com");
//        approver.setPhone("0263528382");
//        approver.setCCCD_ID("987654321213");
//
//        BookCategory bookCategory = new BookCategory("manga","manga description");
//        bookCategory.setId(1L);
//
//        BookClassNumber classNumber= new BookClassNumber();
//        classNumber.setId(1L);
//        classNumber.setName("001");
//
//        Book book1 = new Book();
//        book1.setVietnameseName("fate stay night");
//        book1.setId(1L);
//        book1.setAuthor("nasu kinoko");
//        book1.setBookPosition("123");
//        book1.setLanguage("tieng viet");
//        book1.setPrice(2.3);
//        book1.setCategory(bookCategory);
//        book1.setClassNumber(classNumber);
//
//        Set<Book> books = new HashSet<Book>();
//        books.add(book1);
//
//        LiquidationTicket liquidationTicket = new LiquidationTicket();
//        liquidationTicket.setId(1L);
//        liquidationTicket.setNumber(12);
//        liquidationTicket.setExport_price(new BigDecimal(65.3));
//        liquidationTicket.setCreator(creator);
//        liquidationTicket.setBooks(books);
//        liquidationTicket.setStatus(TicketStatus.PENDING);
//        liquidationTicket.setApprover(approver);
//
//
//        liquidationTicket liquidationDto = liquidationMapper.toEntity_create();
//
//        LiquidationFullInfoDto liquidationDto1 = new LiquidationFullInfoDto();
//        liquidationDto1.setId(1L);
//        liquidationDto1.setNumber(12);
//        liquidationDto1.setExport_price(new BigDecimal(65.3));
//        liquidationDto1.setCreator(profileMapper.toMinInfoDto(creator));
//        liquidationDto1.setStatus(TicketStatus.PENDING);
//        Set<BookDto> bookDtos = new HashSet<BookDto>();
//        books.forEach(book -> {
//            bookDtos.add(bookMapper.toDto(book));
//        });
//        liquidationDto1.setBooks(bookDtos);
//
//
//        assertSame(liquidationDto,liquidationDto1);
//
//    }
//}

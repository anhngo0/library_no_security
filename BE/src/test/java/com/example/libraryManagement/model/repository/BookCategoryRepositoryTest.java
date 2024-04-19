package com.example.libraryManagement.model.repository;

import com.example.libraryManagement.model.entity.BookCategory;
import com.example.libraryManagement.model.entity.QBookCategory;
import com.querydsl.core.BooleanBuilder;
import jakarta.transaction.Transactional;
import org.h2.tools.Server;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Server.class)
class BookCategoryRepositoryTest {
    @Autowired
    private BookCategoryRepository underTest;
    private static final QBookCategory bookCategory = QBookCategory.bookCategory;

    @Test
    void checkBookCategory(){
        BookCategory category = new BookCategory("trinh tham", "test case");
        underTest.save(category);
//        BooleanBuilder builder = new BooleanBuilder();
//        Iterable<BookCategory> bookCategory1 = underTest.findAll(builder.and(bookCategory.name.containsIgnoreCase("tr")));
//        Iterator<BookCategory> iterator = bookCategory1.iterator();
//        while (iterator.hasNext()){
//            BookCategory bookCategory2 = iterator.next();
//            assertThat(bookCategory2).isEqualTo(new BookCategory("trinh tham", "test case"));
//        }
    }
}
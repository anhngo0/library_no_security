package com.example.libraryManagement.query.predicate;

import com.example.libraryManagement.model.entity.QBook;
import com.example.libraryManagement.query.params.GetBookParams;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.StringUtils;

public class BookPredicate {
    private static final QBook book = QBook.book;
    public static BooleanBuilder getBooks(GetBookParams getBookParams){
        BooleanBuilder where = new BooleanBuilder();
        return where.and(commonAttributeContainKeyword(getBookParams.getKeyword()));
    }

    private static BooleanExpression commonAttributeContainKeyword(String keyword){
        return StringUtils.isNotBlank(keyword) ?
                book.vietnameseName.containsIgnoreCase(keyword)
                        .or(book.alterName.containsIgnoreCase(keyword))
                        .or(book.author.containsIgnoreCase(keyword))
                        .or(book.publisher.containsIgnoreCase(keyword))
                        .or(book.language.containsIgnoreCase(keyword))
                        .or(book.description.containsIgnoreCase(keyword))
                : null;
    }
}

package com.example.libraryManagement.query.predicate;

import com.example.libraryManagement.Utils.CommonUtils;
import com.example.libraryManagement.model.entity.Book;
import com.example.libraryManagement.model.entity.BookStatus;
import com.example.libraryManagement.model.entity.QBook;
import com.example.libraryManagement.query.params.GetBookParams;
import com.example.libraryManagement.query.params.GetImportTicketParams;
import com.example.libraryManagement.query.params.GetLiquidationTicketParams;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.StyledEditorKit;
import java.time.Year;

import static org.apache.commons.lang3.BooleanUtils.and;

public class BookPredicate {
    private static final QBook book = QBook.book;
    public static BooleanBuilder getBooks(GetBookParams getBookParams){

        BooleanBuilder where = new BooleanBuilder();
        return where
                .and(matchCategoryId(getBookParams.getCategoryId()))
                .and(matchClassNumberId(getBookParams.getClassNumberId()))
                .and(quantityInBetween(getBookParams.getQuantityFrom(),getBookParams.getQuantityTo()))
                .and(yearOfPublicationInBetween(getBookParams.getYearOfPublicationFrom(),getBookParams.getYearOfPublicationTo()))
                .and(commonAttributeContainKeyword(getBookParams.getKeyword()))
                ;
    }

    public static BooleanBuilder getBooksByLiquidationTicketId(GetLiquidationTicketParams getLiquidationTicketParams){
        BooleanBuilder where = new BooleanBuilder();
        return where
                .and(matchLiquidationId(getLiquidationTicketParams.getId()))
                .and(statusIn(BookStatus.INACTIVE,BookStatus.LIQUIDATED))
                .and(commonAttributeContainKeyword(getLiquidationTicketParams.getKeyword()));

    }

    private static BooleanExpression matchLiquidationId(Long id){
        return ObjectUtils.isNotEmpty(id) ? book.liquidationTicket.id.eq(id):null;
    }

    private static BooleanExpression matchCategoryId(Long id){
        return id != null ? book.category.id.eq(id) : null;
    }

    private static BooleanExpression matchClassNumberId(Long id){
        return id != null ? book.classNumber.id.eq(id):null;
    }

    private static BooleanExpression statusIn(BookStatus... statuses) {
        return ObjectUtils.isNotEmpty(statuses) ? book.status.in(statuses) : null;
    }

    private static BooleanExpression yearOfPublicationInBetween(Year from, Year to) {
        return CommonUtils.validateYearBetween(from, to) ? book.year_of_publication.between(from, to):null;
    }
    private static BooleanExpression quantityInBetween(Integer from, Integer to){
        return CommonUtils.validateIntegerBetween(from, to) ? book.quantity.between(from,to):null;
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

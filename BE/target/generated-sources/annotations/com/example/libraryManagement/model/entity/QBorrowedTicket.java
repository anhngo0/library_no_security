package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBorrowedTicket is a Querydsl query type for BorrowedTicket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBorrowedTicket extends EntityPathBase<BorrowedTicket> {

    private static final long serialVersionUID = 1880955205L;

    public static final QBorrowedTicket borrowedTicket = new QBorrowedTicket("borrowedTicket");

    public final ListPath<Book, QBook> books = this.<Book, QBook>createList("books", Book.class, QBook.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> borrowDate = createDateTime("borrowDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> PromisedReturnDate = createDateTime("PromisedReturnDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> returnDate = createDateTime("returnDate", java.util.Date.class);

    public QBorrowedTicket(String variable) {
        super(BorrowedTicket.class, forVariable(variable));
    }

    public QBorrowedTicket(Path<? extends BorrowedTicket> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBorrowedTicket(PathMetadata metadata) {
        super(BorrowedTicket.class, metadata);
    }

}


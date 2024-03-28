package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1346257134L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBook book = new QBook("book");

    public final StringPath alterName = createString("alterName");

    public final StringPath author = createString("author");

    public final ListPath<BorrowedTicket, QBorrowedTicket> borrowedTickets = this.<BorrowedTicket, QBorrowedTicket>createList("borrowedTickets", BorrowedTicket.class, QBorrowedTicket.class, PathInits.DIRECT2);

    public final QBookCategory category;

    public final QBookClassNumber classNumber;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> import_price = createNumber("import_price", Double.class);

    public final NumberPath<java.math.BigInteger> ISBNNumber = createNumber("ISBNNumber", java.math.BigInteger.class);

    public final StringPath language = createString("language");

    public final StringPath publisher = createString("publisher");

    public final EnumPath<BookStatus> status = createEnum("status", BookStatus.class);

    public final StringPath vietnameseName = createString("vietnameseName");

    public final DateTimePath<java.util.Date> year_of_publication = createDateTime("year_of_publication", java.util.Date.class);

    public QBook(String variable) {
        this(Book.class, forVariable(variable), INITS);
    }

    public QBook(Path<? extends Book> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBook(PathMetadata metadata, PathInits inits) {
        this(Book.class, metadata, inits);
    }

    public QBook(Class<? extends Book> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QBookCategory(forProperty("category")) : null;
        this.classNumber = inits.isInitialized("classNumber") ? new QBookClassNumber(forProperty("classNumber")) : null;
    }

}


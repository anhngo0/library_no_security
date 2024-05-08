package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBorrowTicket is a Querydsl query type for BorrowTicket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBorrowTicket extends EntityPathBase<BorrowTicket> {

    private static final long serialVersionUID = 1196303974L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBorrowTicket borrowTicket = new QBorrowTicket("borrowTicket");

    public final SetPath<Book, QBook> books = this.<Book, QBook>createSet("books", Book.class, QBook.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> borrowed_date = createDateTime("borrowed_date", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProfile librarian;

    public final QProfile member;

    public final StringPath note = createString("note");

    public final DateTimePath<java.util.Date> returned_date = createDateTime("returned_date", java.util.Date.class);

    public final EnumPath<TicketStatus> status = createEnum("status", TicketStatus.class);

    public QBorrowTicket(String variable) {
        this(BorrowTicket.class, forVariable(variable), INITS);
    }

    public QBorrowTicket(Path<? extends BorrowTicket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBorrowTicket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBorrowTicket(PathMetadata metadata, PathInits inits) {
        this(BorrowTicket.class, metadata, inits);
    }

    public QBorrowTicket(Class<? extends BorrowTicket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.librarian = inits.isInitialized("librarian") ? new QProfile(forProperty("librarian")) : null;
        this.member = inits.isInitialized("member") ? new QProfile(forProperty("member")) : null;
    }

}


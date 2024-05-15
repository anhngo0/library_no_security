package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTicket is a Querydsl query type for Ticket
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QTicket extends EntityPathBase<Ticket> {

    private static final long serialVersionUID = 1477379025L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTicket ticket = new QTicket("ticket");

    public final DateTimePath<java.time.LocalDateTime> approval_date = createDateTime("approval_date", java.time.LocalDateTime.class);

    public final QProfile approver;

    public final StringPath approver_note = createString("approver_note");

    public final DateTimePath<java.time.LocalDateTime> created_date = createDateTime("created_date", java.time.LocalDateTime.class);

    public final QProfile creator;

    public final StringPath creator_note = createString("creator_note");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<TicketStatus> status = createEnum("status", TicketStatus.class);

    public QTicket(String variable) {
        this(Ticket.class, forVariable(variable), INITS);
    }

    public QTicket(Path<? extends Ticket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTicket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTicket(PathMetadata metadata, PathInits inits) {
        this(Ticket.class, metadata, inits);
    }

    public QTicket(Class<? extends Ticket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.approver = inits.isInitialized("approver") ? new QProfile(forProperty("approver")) : null;
        this.creator = inits.isInitialized("creator") ? new QProfile(forProperty("creator")) : null;
    }

}


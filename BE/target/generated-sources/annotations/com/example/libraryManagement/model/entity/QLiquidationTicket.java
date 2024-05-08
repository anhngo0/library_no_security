package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLiquidationTicket is a Querydsl query type for LiquidationTicket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLiquidationTicket extends EntityPathBase<LiquidationTicket> {

    private static final long serialVersionUID = 1924360640L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLiquidationTicket liquidationTicket = new QLiquidationTicket("liquidationTicket");

    public final QTicket _super;

    //inherited
    public final StringPath appover_note;

    //inherited
    public final DateTimePath<java.util.Date> approval_date;

    // inherited
    public final QProfile approver;

    public final SetPath<Book, QBook> books = this.<Book, QBook>createSet("books", Book.class, QBook.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> created_date;

    // inherited
    public final QProfile creator;

    //inherited
    public final StringPath creator_note;

    public final NumberPath<Double> export_price = createNumber("export_price", Double.class);

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final EnumPath<TicketStatus> status;

    public final NumberPath<Integer> totalQuantity = createNumber("totalQuantity", Integer.class);

    public QLiquidationTicket(String variable) {
        this(LiquidationTicket.class, forVariable(variable), INITS);
    }

    public QLiquidationTicket(Path<? extends LiquidationTicket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLiquidationTicket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLiquidationTicket(PathMetadata metadata, PathInits inits) {
        this(LiquidationTicket.class, metadata, inits);
    }

    public QLiquidationTicket(Class<? extends LiquidationTicket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QTicket(type, metadata, inits);
        this.appover_note = _super.appover_note;
        this.approval_date = _super.approval_date;
        this.approver = _super.approver;
        this.created_date = _super.created_date;
        this.creator = _super.creator;
        this.creator_note = _super.creator_note;
        this.id = _super.id;
        this.status = _super.status;
    }

}


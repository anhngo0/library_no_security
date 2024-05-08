package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImportWarehouseTicket is a Querydsl query type for ImportWarehouseTicket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImportWarehouseTicket extends EntityPathBase<ImportTicket> {

    private static final long serialVersionUID = -559989275L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImportWarehouseTicket importWarehouseTicket = new QImportWarehouseTicket("importWarehouseTicket");

    public final QTicket _super;

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

    //inherited
    public final NumberPath<Long> id;

    public final StringPath importWay = createString("importWay");

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    //inherited
    public final EnumPath<TicketStatus> status;

    public final StringPath supplier = createString("supplier");

    public QImportWarehouseTicket(String variable) {
        this(ImportTicket.class, forVariable(variable), INITS);
    }

    public QImportWarehouseTicket(Path<? extends ImportTicket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImportWarehouseTicket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImportWarehouseTicket(PathMetadata metadata, PathInits inits) {
        this(ImportTicket.class, metadata, inits);
    }

    public QImportWarehouseTicket(Class<? extends ImportTicket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QTicket(type, metadata, inits);
        this.approval_date = _super.approval_date;
        this.approver = _super.approver;
        this.created_date = _super.created_date;
        this.creator = _super.creator;
        this.creator_note = _super.creator_note;
        this.id = _super.id;
        this.status = _super.status;
    }

}


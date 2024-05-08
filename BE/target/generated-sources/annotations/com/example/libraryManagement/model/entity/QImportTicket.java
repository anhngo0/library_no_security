package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImportTicket is a Querydsl query type for ImportTicket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImportTicket extends EntityPathBase<ImportTicket> {

    private static final long serialVersionUID = 1190194198L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImportTicket importTicket = new QImportTicket("importTicket");

    public final QTicket _super;

    //inherited
    public final StringPath appover_note;

    //inherited
    public final DateTimePath<java.util.Date> approval_date;

    // inherited
    public final QProfile approver;

    //inherited
    public final DateTimePath<java.util.Date> created_date;

    // inherited
    public final QProfile creator;

    //inherited
    public final StringPath creator_note;

    //inherited
    public final NumberPath<Long> id;

    public final StringPath import_way = createString("import_way");

    //inherited
    public final EnumPath<TicketStatus> status;

    public final StringPath supplier = createString("supplier");

    public final NumberPath<Double> totalPrice = createNumber("totalPrice", Double.class);

    public final NumberPath<Integer> totalQuantity = createNumber("totalQuantity", Integer.class);

    public QImportTicket(String variable) {
        this(ImportTicket.class, forVariable(variable), INITS);
    }

    public QImportTicket(Path<? extends ImportTicket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImportTicket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImportTicket(PathMetadata metadata, PathInits inits) {
        this(ImportTicket.class, metadata, inits);
    }

    public QImportTicket(Class<? extends ImportTicket> type, PathMetadata metadata, PathInits inits) {
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


package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookClassNumber is a Querydsl query type for BookClassNumber
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookClassNumber extends EntityPathBase<BookClassNumber> {

    private static final long serialVersionUID = 2073533715L;

    public static final QBookClassNumber bookClassNumber = new QBookClassNumber("bookClassNumber");

    public final StringPath classNumber = createString("classNumber");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QBookClassNumber(String variable) {
        super(BookClassNumber.class, forVariable(variable));
    }

    public QBookClassNumber(Path<? extends BookClassNumber> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookClassNumber(PathMetadata metadata) {
        super(BookClassNumber.class, metadata);
    }

}


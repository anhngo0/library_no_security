package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookCategory is a Querydsl query type for BookCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookCategory extends EntityPathBase<BookCategory> {

    private static final long serialVersionUID = 746230796L;

    public static final QBookCategory bookCategory = new QBookCategory("bookCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath note = createString("note");

    public QBookCategory(String variable) {
        super(BookCategory.class, forVariable(variable));
    }

    public QBookCategory(Path<? extends BookCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookCategory(PathMetadata metadata) {
        super(BookCategory.class, metadata);
    }

}


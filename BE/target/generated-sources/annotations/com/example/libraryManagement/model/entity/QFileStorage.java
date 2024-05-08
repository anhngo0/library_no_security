package com.example.libraryManagement.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFileStorage is a Querydsl query type for FileStorage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileStorage extends EntityPathBase<FileStorage> {

    private static final long serialVersionUID = -851436614L;

    public static final QFileStorage fileStorage = new QFileStorage("fileStorage");

    public final NumberPath<Long> associatedEntityId = createNumber("associatedEntityId", Long.class);

    public final StringPath associatedEntityType = createString("associatedEntityType");

    public final StringPath contentType = createString("contentType");

    public final ArrayPath<byte[], Byte> data = createArray("data", byte[].class);

    public final EnumPath<FileDescription> description = createEnum("description", FileDescription.class);

    public final StringPath extension = createString("extension");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QFileStorage(String variable) {
        super(FileStorage.class, forVariable(variable));
    }

    public QFileStorage(Path<? extends FileStorage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileStorage(PathMetadata metadata) {
        super(FileStorage.class, metadata);
    }

}


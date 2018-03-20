package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomsObjectInformation is a Querydsl query type for RoomsObjectInformation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoomsObjectInformation extends EntityPathBase<RoomsObjectInformation> {

    private static final long serialVersionUID = 933185148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomsObjectInformation roomsObjectInformation = new QRoomsObjectInformation("roomsObjectInformation");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRoomsObject roomsObject;

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QRoomsObjectInformation(String variable) {
        this(RoomsObjectInformation.class, forVariable(variable), INITS);
    }

    public QRoomsObjectInformation(Path<? extends RoomsObjectInformation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomsObjectInformation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomsObjectInformation(PathMetadata metadata, PathInits inits) {
        this(RoomsObjectInformation.class, metadata, inits);
    }

    public QRoomsObjectInformation(Class<? extends RoomsObjectInformation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomsObject = inits.isInitialized("roomsObject") ? new QRoomsObject(forProperty("roomsObject"), inits.get("roomsObject")) : null;
    }

}


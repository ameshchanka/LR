package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomsObjectImage is a Querydsl query type for RoomsObjectImage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoomsObjectImage extends EntityPathBase<RoomsObjectImage> {

    private static final long serialVersionUID = 508475051L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomsObjectImage roomsObjectImage = new QRoomsObjectImage("roomsObjectImage");

    public final QImage _super = new QImage(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath path = _super.path;

    public final QRoomsObject roomsObject;

    public QRoomsObjectImage(String variable) {
        this(RoomsObjectImage.class, forVariable(variable), INITS);
    }

    public QRoomsObjectImage(Path<? extends RoomsObjectImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomsObjectImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomsObjectImage(PathMetadata metadata, PathInits inits) {
        this(RoomsObjectImage.class, metadata, inits);
    }

    public QRoomsObjectImage(Class<? extends RoomsObjectImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomsObject = inits.isInitialized("roomsObject") ? new QRoomsObject(forProperty("roomsObject"), inits.get("roomsObject")) : null;
    }

}


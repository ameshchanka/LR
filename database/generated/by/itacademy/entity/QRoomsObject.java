package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomsObject is a Querydsl query type for RoomsObject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoomsObject extends EntityPathBase<RoomsObject> {

    private static final long serialVersionUID = -688104304L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomsObject roomsObject = new QRoomsObject("roomsObject");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QAddress address;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QRoomsObjectInformation info;

    public final NumberPath<Float> lat = createNumber("lat", Float.class);

    public final NumberPath<Float> lng = createNumber("lng", Float.class);

    public final StringPath name = createString("name");

    public final SetPath<Room, QRoom> rooms = this.<Room, QRoom>createSet("rooms", Room.class, QRoom.class, PathInits.DIRECT2);

    public final SetPath<RoomsObjectImage, QRoomsObjectImage> roomsObjectImages = this.<RoomsObjectImage, QRoomsObjectImage>createSet("roomsObjectImages", RoomsObjectImage.class, QRoomsObjectImage.class, PathInits.DIRECT2);

    public QRoomsObject(String variable) {
        this(RoomsObject.class, forVariable(variable), INITS);
    }

    public QRoomsObject(Path<? extends RoomsObject> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomsObject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomsObject(PathMetadata metadata, PathInits inits) {
        this(RoomsObject.class, metadata, inits);
    }

    public QRoomsObject(Class<? extends RoomsObject> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address"), inits.get("address")) : null;
        this.info = inits.isInitialized("info") ? new QRoomsObjectInformation(forProperty("info"), inits.get("info")) : null;
    }

}


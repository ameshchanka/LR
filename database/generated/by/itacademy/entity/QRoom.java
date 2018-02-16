package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = 2079429314L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoom room = new QRoom("room");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<LeaseAd, QLeaseAd> leaseAds = this.<LeaseAd, QLeaseAd>createSet("leaseAds", LeaseAd.class, QLeaseAd.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final SetPath<RoomImage, QRoomImage> roomImages = this.<RoomImage, QRoomImage>createSet("roomImages", RoomImage.class, QRoomImage.class, PathInits.DIRECT2);

    public final QRoomsObject roomsObject;

    public final NumberPath<Float> square = createNumber("square", Float.class);

    public final QUser user;

    public QRoom(String variable) {
        this(Room.class, forVariable(variable), INITS);
    }

    public QRoom(Path<? extends Room> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoom(PathMetadata metadata, PathInits inits) {
        this(Room.class, metadata, inits);
    }

    public QRoom(Class<? extends Room> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomsObject = inits.isInitialized("roomsObject") ? new QRoomsObject(forProperty("roomsObject"), inits.get("roomsObject")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}


package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = -562107219L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAddress address = new QAddress("address");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath objectNumberStr = createString("objectNumberStr");

    public final QRoomsObject roomsObject;

    public final QStreet street;

    public QAddress(String variable) {
        this(Address.class, forVariable(variable), INITS);
    }

    public QAddress(Path<? extends Address> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAddress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAddress(PathMetadata metadata, PathInits inits) {
        this(Address.class, metadata, inits);
    }

    public QAddress(Class<? extends Address> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomsObject = inits.isInitialized("roomsObject") ? new QRoomsObject(forProperty("roomsObject"), inits.get("roomsObject")) : null;
        this.street = inits.isInitialized("street") ? new QStreet(forProperty("street"), inits.get("street")) : null;
    }

}


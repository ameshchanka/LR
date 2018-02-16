package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStreet is a Querydsl query type for Street
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStreet extends EntityPathBase<Street> {

    private static final long serialVersionUID = 1205109802L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStreet street = new QStreet("street");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final SetPath<Address, QAddress> addresses = this.<Address, QAddress>createSet("addresses", Address.class, QAddress.class, PathInits.DIRECT2);

    public final QCity city;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QStreet(String variable) {
        this(Street.class, forVariable(variable), INITS);
    }

    public QStreet(Path<? extends Street> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStreet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStreet(PathMetadata metadata, PathInits inits) {
        this(Street.class, metadata, inits);
    }

    public QStreet(Class<? extends Street> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.city = inits.isInitialized("city") ? new QCity(forProperty("city"), inits.get("city")) : null;
    }

}


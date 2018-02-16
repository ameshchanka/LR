package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLeaseAd is a Querydsl query type for LeaseAd
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLeaseAd extends EntityPathBase<LeaseAd> {

    private static final long serialVersionUID = 636385494L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLeaseAd leaseAd = new QLeaseAd("leaseAd");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> dateStartLease = createDateTime("dateStartLease", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> dateStopLease = createDateTime("dateStopLease", java.time.LocalDateTime.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<Message, QMessage> messages = this.<Message, QMessage>createSet("messages", Message.class, QMessage.class, PathInits.DIRECT2);

    public final NumberPath<Float> price = createNumber("price", Float.class);

    public final QRoom room;

    public QLeaseAd(String variable) {
        this(LeaseAd.class, forVariable(variable), INITS);
    }

    public QLeaseAd(Path<? extends LeaseAd> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLeaseAd(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLeaseAd(PathMetadata metadata, PathInits inits) {
        this(LeaseAd.class, metadata, inits);
    }

    public QLeaseAd(Class<? extends LeaseAd> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.room = inits.isInitialized("room") ? new QRoom(forProperty("room"), inits.get("room")) : null;
    }

}


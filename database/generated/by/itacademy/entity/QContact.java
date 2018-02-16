package by.itacademy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QContact is a Querydsl query type for Contact
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QContact extends BeanPath<Contact> {

    private static final long serialVersionUID = 1537111257L;

    public static final QContact contact = new QContact("contact");

    public final StringPath phone = createString("phone");

    public final StringPath skype = createString("skype");

    public final StringPath telegram = createString("telegram");

    public final StringPath viber = createString("viber");

    public QContact(String variable) {
        super(Contact.class, forVariable(variable));
    }

    public QContact(Path<? extends Contact> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContact(PathMetadata metadata) {
        super(Contact.class, metadata);
    }

}


package by.itacademy.dao;

import by.itacademy.entity.Message;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class MessageDAO {

    public Message get(Session session, long id) {
        return session.get(Message.class, id);
    }

    public void create (Session session, Message item) {
        session.save(item);
    }
}

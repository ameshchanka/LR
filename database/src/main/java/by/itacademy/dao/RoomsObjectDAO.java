package by.itacademy.dao;

import by.itacademy.entity.RoomsObject;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectDAO {

    public RoomsObject get(Session session, long id) {
        return session.get(RoomsObject.class, id);
    }

    public void create (Session session, RoomsObject item) {
        session.save(item);
    }
}

package by.itacademy.dao;

import by.itacademy.entity.RoomsObjectImage;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectImageDAO {

    public RoomsObjectImage get(Session session, long id) {
        return session.get(RoomsObjectImage.class, id);
    }

    public void create (Session session, RoomsObjectImage item) {
        session.save(item);
    }
}

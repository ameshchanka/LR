package by.itacademy.dao;

import by.itacademy.entity.RoomImage;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomImageDAO {

    public RoomImage get(Session session, long id) {
        return session.get(RoomImage.class, id);
    }

    public void create (Session session, RoomImage item) {
        session.save(item);
    }
}

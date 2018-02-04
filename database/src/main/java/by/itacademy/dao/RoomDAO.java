package by.itacademy.dao;

import by.itacademy.entity.Room;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomDAO {

    public Room get(Session session, long id) {
        return session.get(Room.class, id);
    }

    public void create (Session session, Room item) {
        session.save(item);
    }
}

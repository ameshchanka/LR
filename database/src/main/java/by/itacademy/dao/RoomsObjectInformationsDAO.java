package by.itacademy.dao;

import by.itacademy.entity.RoomsObjectInformation;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectInformationsDAO {

    public RoomsObjectInformation get(Session session, long id) {
        return session.get(RoomsObjectInformation.class, id);
    }

    public void create(Session session, RoomsObjectInformation item) {
        session.save(item);
    }
}

package by.itacademy.dao;

import by.itacademy.entity.Street;
import org.hibernate.Session;

/**
 * Created by User on 04.02.2018.
 */
public class StreetDAO {

    public Street get(Session session, long id) {
        return session.get(Street.class, id);
    }

    public void create (Session session, Street item) {
        session.save(item);
    }
}


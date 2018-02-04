package by.itacademy.dao;

import by.itacademy.entity.City;
import org.hibernate.Session;

/**
 * Created by User on 04.02.2018.
 */
public class CityDAO {

    public City get(Session session, long id) {
        return session.get(City.class, id);
    }

    public void create (Session session, City item) {
        session.save(item);
    }
}

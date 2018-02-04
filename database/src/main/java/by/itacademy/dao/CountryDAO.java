package by.itacademy.dao;

import by.itacademy.entity.Country;
import org.hibernate.Session;

/**
 * Created by User on 04.02.2018.
 */
public class CountryDAO {

    public Country get(Session session, long id) {
        return session.get(Country.class, id);
    }

    public void create (Session session, Country item) {
        session.save(item);
    }
}

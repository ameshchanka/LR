package by.itacademy.dao;

import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class CityDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        City item = DAO.getInstance().cityDAO.get(session, 1L);
        assertThat(item.getName(), equalTo("Minsk"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country temp = session.get(Country.class, 1L);
        City item = new City("Gomel", temp);
        DAO.getInstance().cityDAO.create(session, item);
        City result = session.get(City.class, 2L);
        assertThat(result.getName(), equalTo("Gomel"));

        session.getTransaction().commit();
        session.close();
    }
}

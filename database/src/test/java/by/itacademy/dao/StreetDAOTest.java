package by.itacademy.dao;

import by.itacademy.entity.City;
import by.itacademy.entity.Street;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class StreetDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Street item = DAO.getInstance().streetDAO.get(session, 1L);
        assertThat(item.getName(), equalTo("Prititskogo"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        City temp = session.get(City.class, 1L);
        Street item = new Street("P.Brovki", temp);
        DAO.getInstance().streetDAO.create(session, item);
        Street result = session.get(Street.class, 5L);
        assertThat(result.getName(), equalTo("P.Brovki"));

        session.getTransaction().commit();
        session.close();
    }
}
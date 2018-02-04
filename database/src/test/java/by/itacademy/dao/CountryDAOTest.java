package by.itacademy.dao;

import by.itacademy.entity.Address;
import by.itacademy.entity.Country;
import by.itacademy.entity.Street;
import by.itacademy.util.EntityTestDataImporter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 04.02.2018.
 */
public class CountryDAOTest {

    private SessionFactory sessionFactory;

    @Before
    public void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        EntityTestDataImporter.getInstance().importTestData(sessionFactory);
    }

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country item = DAO.getInstance().countryDAO.get(session, 1L);
        assertThat(item.getName(), equalTo("Belarus"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country item = new Country("Ukraine");
        DAO.getInstance().countryDAO.create(session, item);
        Country result = session.get(Country.class, 2L);
        assertThat(result.getName(), equalTo("Ukraine"));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}

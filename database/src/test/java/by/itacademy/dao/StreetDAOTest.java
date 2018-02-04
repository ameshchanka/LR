package by.itacademy.dao;

import by.itacademy.entity.Street;
import by.itacademy.entity.City;
import by.itacademy.util.EntityTestDataImporter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by User on 04.02.2018.
 */
public class StreetDAOTest {

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
        Street result = session.get(Street.class, 3L);
        assertThat(result.getName(), equalTo("P.Brovki"));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
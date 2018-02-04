package by.itacademy.dao;

import by.itacademy.entity.Address;
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
 * Created by a.meshchanka on 03.02.2018.
 */
public class AddressDAOTest {

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

        Address item = DAO.getInstance().addressDAO.get(session, 1L);
        assertThat(item.getObjectNumberStr(), equalTo("65"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Street temp = session.get(Street.class, 2L);
        Address item = new Address("38-79", temp);
        DAO.getInstance().addressDAO.create(session, item);
        Address result = session.get(Address.class, 3L);
        assertThat(result.getObjectNumberStr(), equalTo("38-79"));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }

}
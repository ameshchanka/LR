package by.itacademy.dao;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
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
public class RoleDAOTest {

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

        Role item = DAO.getInstance().roleDAO.get(session, 1L);
        assertThat(item.getRole(), equalTo("admin"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Role item = new Role("moderator");
        DAO.getInstance().roleDAO.create(session, item);
        Role result = session.get(Role.class, 4L);
        assertThat(result.getRole(), equalTo("moderator"));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
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

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class UserDAOTest {

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

        User item = DAO.getInstance().userDAO.get(session, 1L);
        assertThat(item.getEmail(), equalTo("admin@admin.com"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Role temp = session.get(Role.class, 1L);
        User item = new User("TestAdmin","test@admin.com","123456789",
                new HashSet<Role>(Arrays.asList(temp)));
        DAO.getInstance().userDAO.create(session, item);
        User result = session.get(User.class, 4L);
        assertThat(result.getName(), equalTo("TestAdmin"));
        assertThat(result.getEmail(), equalTo("test@admin.com"));

        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
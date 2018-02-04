package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoleDAOTest extends BaseDAOTest {

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
}
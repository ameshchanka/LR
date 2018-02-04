package by.itacademy.dao;

import by.itacademy.entity.Address;
import by.itacademy.entity.RoomsObject;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        RoomsObject item = DAO.getInstance().roomsObjectDAO.get(session, 1L);
        assertThat(item.getName(), equalTo("Zamok"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Address temp = session.get(Address.class, 4L);
        RoomsObject item = new RoomsObject("Skala", temp);
        DAO.getInstance().roomsObjectDAO.create(session, item);
        RoomsObject result = session.get(RoomsObject.class, 4L);
        assertThat(result.getName(), equalTo("Skala"));

        session.getTransaction().commit();
        session.close();
    }
}
package by.itacademy.dao;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Room item = DAO.getInstance().roomDAO.get(session, 1L);
        assertThat(item.getName(), equalTo("A24"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = session.get(User.class, 2L);
        RoomsObject temp = session.get(RoomsObject.class, 1L);
        Room item = new Room("J35", 540.4F, temp, user);
        DAO.getInstance().roomDAO.create(session, item);
        Room result = session.get(Room.class, 5L);
        assertThat(result.getRoomsObject().getName(), equalTo("Zamok"));
        assertThat(result.getName(), equalTo("J35"));

        session.getTransaction().commit();
        session.close();
    }

}
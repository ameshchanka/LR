package by.itacademy.dao;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomImage;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectImage;
import org.hibernate.Session;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomImageDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        RoomImage item = DAO.getInstance().roomImageDAO.get(session, 2L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPath(), equalTo("img_sc_zamok_room001.jpg"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        File f = IMPORTER.createFile("img_sc_zamok_room002.jpg");
        Room rTemp = session.get(Room.class, 1L);
        RoomImage item = new RoomImage(f.getName(), rTemp);
        DAO.getInstance().roomImageDAO.create(session, item);
        RoomImage result = session.get(RoomImage.class, 3L);
        assertThat(result.getRoom().getName(), equalTo("A24"));
        assertThat(result.getPath(), equalTo("img_sc_zamok_room002.jpg"));

        session.getTransaction().commit();
        session.close();
    }
}
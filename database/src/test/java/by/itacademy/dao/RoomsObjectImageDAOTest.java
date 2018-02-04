package by.itacademy.dao;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectImage;
import org.hibernate.Session;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectImageDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        RoomsObjectImage item = DAO.getInstance()
                .roomsObjectImageDAO.get(session, 1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        File f = IMPORTER.createFile("img_sc_zamok002.jpg");
        RoomsObject roTemp = session.get(RoomsObject.class, 1L);
        RoomsObjectImage item = new RoomsObjectImage(f.getName(),roTemp);
        DAO.getInstance().roomsObjectImageDAO.create(session, item);
        RoomsObjectImage result = session.get(RoomsObjectImage.class, 3L);
        assertThat(result.getRoomsObject().getName(), equalTo("Zamok"));
        assertThat(result.getPath(), equalTo("img_sc_zamok002.jpg"));

        session.getTransaction().commit();
        session.close();
    }
}
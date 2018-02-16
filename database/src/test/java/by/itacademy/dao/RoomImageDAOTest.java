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
        RoomImage item = DAO.getInstance().getRoomImageDAO().findById(2L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPath(), equalTo("img_sc_zamok_room001.jpg"));
    }

    @Test
    public void create() throws Exception {
        File f = IMPORTER.createFile("img_sc_zamok_room002.jpg");
        Room rTemp = DAO.getInstance().getRoomDAO().findById(1L);
        RoomImage item = new RoomImage(f.getName(), rTemp);
        DAO.getInstance().getRoomImageDAO().save(item);
        RoomImage result = DAO.getInstance().getRoomImageDAO().findById(3L);
        assertThat(result.getRoom().getName(), equalTo("A24"));
        assertThat(result.getPath(), equalTo("img_sc_zamok_room002.jpg"));
    }
}